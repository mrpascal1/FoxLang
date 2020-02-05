package com.foxlang.fox;

import java.util.HashMap;
import java.util.Map;

class FoxInstance {
    private FoxClass klass;
    private final Map<String, Object> fields = new HashMap<>();

    FoxInstance(FoxClass klass) {
        this.klass = klass;
    }

    Object get(Token name) {
        if (fields.containsKey(name.lexeme)) {
            return fields.get(name.lexeme);
        }

        FoxFunction method = klass.findMethod(this, name.lexeme);
        if (method != null) return method;

        throw new RuntimeError(name,
                "Undefined property '" + name.lexeme + "'.");
    }

    void set(Token name, Object value) {
        fields.put(name.lexeme, value);
    }

    @Override
    public String toString() {
        return klass.name + " instance";
    }
}
