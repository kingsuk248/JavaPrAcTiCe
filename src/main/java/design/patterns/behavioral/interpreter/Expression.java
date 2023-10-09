package design.patterns.behavioral.interpreter;

import java.util.List;

interface Expression {
    List<String> interpret(Context ctx);
}
