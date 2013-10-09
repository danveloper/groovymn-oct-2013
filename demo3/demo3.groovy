@GrabResolver("http://oss.jfrog.org/artifactory/libs-snapshot")
@Grab("org.ratpack-framework:ratpack-groovy:0.9.0-SNAPSHOT")
import static org.ratpackframework.groovy.RatpackScript.ratpack
import static groovy.json.JsonOutput.toJson
import groovy.xml.MarkupBuilder
ratpack {
  handlers {
    get {
      respond byContent
        .plainText { response.send "You wanted it? You got it!" }
        .json { response.send toJson([msg: "You want JSON? Here!"]) }
        .xml {
          def sw = new StringWriter()
          new MarkupBuilder(sw).with { 
            b -> b.ratpack { msg "You want XML? Here!" } }
          response.send sw.toString()
        }
    }
  }
}
