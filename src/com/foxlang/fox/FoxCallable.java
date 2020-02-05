package com.foxlang.fox;

import java.util.List;

interface FoxCallable {
    int arity();
    Object call(Interpreter interpreter, List<Object> arguments);
}
