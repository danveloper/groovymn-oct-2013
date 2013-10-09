package groovymn

import com.google.inject.AbstractModule

/**
 * User: danielwoods
 * Date: 10/8/13
 */
class AppModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(MessageResolver).toInstance(
      new MessageResolver(
        new Properties().with {
          load this.class.getResourceAsStream("/messages.properties")
          it
        }
      )
    )
  }
}






