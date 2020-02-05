package com.foxlang.fox;

import java.util.List;
import java.util.Map;

class FoxClass extends FoxInstance implements FoxCallable {
    final String name;
    final FoxClass superclass;
    private final Map<String, FoxFunction> methods;

    FoxClass(FoxClass metaclass, String name, FoxClass superclass,
             Map<String, FoxFunction> methods) {
        super(metaclass);
        this.name = name;
        this.superclass = superclass;
        this.methods = methods;
    }

    FoxFunction findMethod(FoxInstance instance, String name) {
        if (methods.containsKey(name)) {
            return methods.get(name).bind(instance);
        }

        if (superclass != null) {
            return superclass.findMethod(instance, name);
        }

        return null;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        FoxInstance instance = new FoxInstance(this);
        FoxFunction initializer = methods.get("init");
        if (initializer != null) {
            initializer.bind(instance).call(interpreter, arguments);
        }

        return instance;
    }

    @Override
    public int arity() {
        FoxFunction initializer = methods.get("init");
        if (initializer == null) return 0;
        return initializer.arity();
    }
}
