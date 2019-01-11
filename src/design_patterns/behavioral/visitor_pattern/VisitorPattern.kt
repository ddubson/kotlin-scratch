package design_patterns.behavioral.visitor_pattern

/**
 * Based on https://refactoring.guru/design-patterns/visitor
 */

interface Shape {
    fun move(x: Int, y: Int)

    fun draw()

    fun accept(visitor: Visitor)
}

class Dot: Shape {
    override fun move(x: Int, y: Int) {
    }

    override fun draw() {
    }

    override fun accept(visitor: Visitor) {
        visitor.visitDot(this)
    }

}

class Circle: Shape {
    override fun move(x: Int, y: Int) {
    }

    override fun draw() {
    }

    override fun accept(visitor: Visitor) {
        visitor.visitCircle(this)
    }
}

class Rectangle: Shape {
    override fun move(x: Int, y: Int) {
    }

    override fun draw() {
    }

    override fun accept(visitor: Visitor) {
        visitor.visitRectangle(this)
    }
}

class CompoundShape: Shape {
    override fun move(x: Int, y: Int) {
    }

    override fun draw() {
    }

    override fun accept(visitor: Visitor) {
        visitor.visitCompoundShape(this)
    }

}

interface Visitor {
    fun visitDot(dot: Dot)

    fun visitCircle(circle: Circle)

    fun visitRectangle(rectangle: Rectangle)

    fun visitCompoundShape(cs: CompoundShape)
}

class XMLExportVisitor: Visitor {
    override fun visitDot(dot: Dot) {
        println("<dot></dot>")
    }

    override fun visitCircle(circle: Circle) {
        println("<circle></circle>")
    }

    override fun visitRectangle(rectangle: Rectangle) {
        println("<rectangle></rectangle>")
    }

    override fun visitCompoundShape(cs: CompoundShape) {
        println("<cs></cs>")
    }
}

fun main(args: Array<String>) {
    val visitor = XMLExportVisitor()

    listOf(Dot(), Circle(), Rectangle(), CompoundShape()).forEach {
        it.accept(visitor)
    }
}