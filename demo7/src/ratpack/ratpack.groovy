

import groovymn.AppModule
import groovymn.MongoDBAssetHandler

import static ratpack.groovy.Groovy.ratpack as _

_ {
  modules {
    register new AppModule()
  }
  handlers { MongoDBAssetHandler mongoAssetHandler ->
    get("event/:name?") {
      def name = pathTokens.name ?: "GroovyMN"
      response.send "Hello, $name!"
    }

    handler mongoAssetHandler
  }

}