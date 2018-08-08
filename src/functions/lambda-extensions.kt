package functions

class Request(val method: String, val query: String, val contentType: String)

class Response(var contents: String, var status: Status) {
    operator fun invoke(status: Status.() -> Unit) {

    }
}

class Status(var code: Int, var description: String)

fun status(status: Status.() -> Unit) {}

class RouteHandler(val request: Request, val response: Response) {
    var executeNext = false
    fun next() {
        executeNext = true
    }
}

// Param is a lambda that is an extension of RouteHandler
fun routeHandler(path: String, f: RouteHandler.() -> Unit): RouteHandler.() -> Unit = f

fun main(args: Array<String>) {
    routeHandler("index.html") {
        if (request.query.isNotBlank()) {
            // process
        }

        response {
            code = 404
            description = "Not Found"
        }
    }
}