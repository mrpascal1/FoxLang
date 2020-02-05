package com.foxlang.fox;

import java.util.List;

abstract class Stmt {
    interface Visitor<R> {
        R visitBlockStmt(Block stmt);
        R visitClassStmt(Class stmt);
        R visitExpressionStmt(Expression stmt);
        R visitFunctionStmt(Function stmt);
        R visitIfStmt(If stmt);
        R visitWhenStmt(When stmt);
        R visitImportStmt(Import stmt);
        R visitReturnStmt(Return stmt);
        R visitVarStmt(Var stmt);
        R visitWhileStmt(While stmt);
    }
    static class Block extends Stmt {
        Block(List<Stmt> statements) {
            this.statements = statements;
        }

        <R> R accept(Visitor<R> visitor) {
            return visitor.visitBlockStmt(this);
        }
        final List<Stmt> statements;
    }
    static class Class extends Stmt {
        Class(Token name, Expr.Variable superclass, List<Stmt.Function> methods, List<Stmt.Function> classMethods) {
            this.name = name;
            this.superclass = superclass;
            this.methods = methods;
            this.classMethods = classMethods;
        }

        <R> R accept(Visitor<R> visitor) {
            return visitor.visitClassStmt(this);
        }
        final Token name;
        final Expr.Variable superclass;
        final List<Stmt.Function> methods;
        final List<Stmt.Function> classMethods;
    }
    static class Expression extends Stmt {
        Expression(Expr expression) {
            this.expression = expression;
        }

        <R> R accept(Visitor<R> visitor) {
            return visitor.visitExpressionStmt(this);
        }
        final Expr expression;
    }
    static class Function extends Stmt {
        Function(Token name, Expr.Function function) {
            this.name = name;
            this.function = function;
        }

        <R> R accept(Visitor<R> visitor) {
            return visitor.visitFunctionStmt(this);
        }
        final Token name;
        final Expr.Function function;
    }
    static class If extends Stmt {
        If(Expr condition, Stmt thenBranch, Stmt elseBranch) {
            this.condition = condition;
            this.thenBranch = thenBranch;
            this.elseBranch = elseBranch;
        }

        <R> R accept(Visitor<R> visitor) {
            return visitor.visitIfStmt(this);
        }
        final Expr condition;
        final Stmt thenBranch;
        final Stmt elseBranch;
    }
    static class When extends Stmt {
        When(Expr condition, Expr left, Stmt branch) {
            this.condition = condition;
            this.left = left;
            this.branch = branch;
        }

        <R> R accept(Visitor<R> visitor) {
            return visitor.visitWhenStmt(this);
        }
        final Expr condition;
        final Expr left;
        final Stmt branch;
    }
    static class Import extends Stmt {
        Import(Token keyword, Expr module) {
            this.keyword = keyword;
            this.module = module;
        }

        <R> R accept(Visitor<R> visitor) {
            return visitor.visitImportStmt(this);
        }
        final Token keyword;
        final Expr module;
    }
    static class Return extends Stmt {
        Return(Token keyword, Expr value) {
            this.keyword = keyword;
            this.value = value;
        }

        <R> R accept(Visitor<R> visitor) {
            return visitor.visitReturnStmt(this);
        }
        final Token keyword;
        final Expr value;
    }
    static class Var extends Stmt {
        Var(Token name, Expr initializer) {
            this.name = name;
            this.initializer = initializer;
        }

        <R> R accept(Visitor<R> visitor) {
            return visitor.visitVarStmt(this);
        }
        final Token name;
        final Expr initializer;
    }
    static class While extends Stmt {
        While(Expr condition, Stmt body) {
            this.condition = condition;
            this.body = body;
        }

        <R> R accept(Visitor<R> visitor) {
            return visitor.visitWhileStmt(this);
        }
        final Expr condition;
        final Stmt body;
    }

    abstract <R> R accept(Visitor<R> visitor);
}