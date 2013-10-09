import org.ratpackframework.handlebars.HandlebarsModule

import static org.ratpackframework.groovy.RatpackScript.ratpack
import static org.ratpackframework.groovy.Template.groovyTemplate
import static org.ratpackframework.handlebars.Template.handlebarsTemplate

ratpack {
  modules {
    register new HandlebarsModule()
  }

  handlers {
    get {
      render groovyTemplate("welcome.html", event: System.getProperty("event", "Groovy MN"))
    }

    prefix("handlebars") {
      get {
        render handlebarsTemplate("simple.html", [foo: "bar", baz: "bleh"])
      }
    }
  }
}




