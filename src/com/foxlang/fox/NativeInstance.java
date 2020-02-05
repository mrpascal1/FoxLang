package com.foxlang.fox;

import java.util.List;
import java.util.Map;

class NativeInstance implements FoxCallable {
    final String name;
    private final Map<String, FoxCallable> methods;

    NativeInstance(String name, Map<String, FoxCallable> methods) {
        this.name = name;
        this.methods = methods;
    }

    FoxCallable findMethod(String name) {
        if (methods.containsKey(name)) {
            return methods.get(name);
        }

        return null;
    }

    @Override
    public String toString() {
        return "<native instance>";
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        FoxCallable initializer = methods.get("init");
        if (initializer != null) {
            initializer.call(interpreter, arguments);
        }

        return this;
    }

    @Override
    public int arity() {
        FoxCallable initializer = methods.get("init");
        if (initializer == null) return 0;
        return initializer.arity();
    }
}