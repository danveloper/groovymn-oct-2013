@GrabResolver("http://oss.jfrog.org/artifactory/libs-snapshot")
@Grab("org.ratpack-framework:ratpack-groovy:0.9.0-SNAPSHOT")
import static org.ratpackframework.groovy.RatpackScript.ratpack

ratpack {
  handlers {
    handler {
      if (request.path.empty) 
        response.headers.set "X-UA-Compatible", "IE=edge,chrome=1"
      next()
    }
    get {
      response.send "text/html",
        "<!DOCTYPE html><html><head></head><body><h1>Hello, Groovy MN!</h1></body></html>"
    }
    prefix("api") {
      handler {
        if (request.method.put) {
          response.send "text/html", "you put me"
        } else {
          next()
        }
      }
      post {
        response.send "text/html", "you posted me"
      }
    }
    assets "public", [] as String[]
  }
}
