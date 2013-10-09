import groovy.xml.MarkupBuilder
import groovymn.AppModule
import groovymn.MessageResolver

import static groovy.json.JsonOutput.toJson
import static org.ratpackframework.groovy.RatpackScript.ratpack

ratpack {
  modules {
    register new AppModule()
  }
  handlers { MessageResolver resolver ->
    get {
      respond byContent
        .plainText { response.send resolver.plain }
        .json { response.send toJson([msg: resolver.json]) }
        .xml {
          def sw = new StringWriter()
          new MarkupBuilder(sw).with {
            b -> b.ratpack { msg resolver.xml }
          }
          response.send sw.toString()
        }
        .html {
          next()
        }
    }
    assets "public", "index.html"
  }
}






