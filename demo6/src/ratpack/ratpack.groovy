import static org.ratpackframework.groovy.RatpackScript.ratpack

ratpack {
  handlers {
    get("event/:name?") {
      def name = pathTokens.name ?: "GroovyMN"
      response.send "Hello, $name!"
    }

    get {
      def name = request.queryParams.name ?: "GroovyMN"
      response.send "Hello, $name!"
    }

    post {
      def name = request.form.name ?: "GroovyMN"
      response.send "Hello, $name!"
    }
  }
}




