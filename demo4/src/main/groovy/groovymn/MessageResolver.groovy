package groovymn

/**
 * User: danielwoods
 * Date: 10/8/13
 */
class MessageResolver {
  private final Properties props

  MessageResolver(Properties properties) {
    this.props = properties
  }

  String getXml() {
    props["message.xml"]
  }

  String getJson() {
    props["message.json"]
  }

  String getPlain() {
    props["message.plain"]
  }

  String get(String key) {
    props[key]
  }
}
