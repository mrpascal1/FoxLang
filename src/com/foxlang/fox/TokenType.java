package com.foxlang.fox;

enum TokenType {
    // Single character tokens
    LEFT_PAREN, RIGHT_PAREN, LEFT_BRACE, RIGHT_BRACE, LEFT_SQUARE, RIGHT_SQUARE,
    COMMA, DOT, MINUS, PERCENTAGE, PLUS, SEMICOLON, SLASH, STAR,
    COLON, QUESTION,

    // 1-2 character tokens
    BANG, BANG_EQUAL,
    EQUAL, EQUAL_EQUAL,
    GREATER, GREATER_EQUAL,
    LESS, LESS_EQUAL, ARROW, INCREMENT, DECREMENT,

    // Literals
    IDENTIFIER, STRING, NUMBER,

    // Keywords, nil and true/false
    AND, CLASS, CONST, ELSE, FALSE, FUN, FOR, IF, IMPORT, STATIC,
    NIL, OR, REF, RETURN, SUPER, THIS, TRUE, VAR, WHILE, WHEN,
    OPEN,

    // Types
    NUM, BOOL, STR,

    // Lonely
    EOF
}