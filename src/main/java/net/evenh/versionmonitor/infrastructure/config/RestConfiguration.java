package net.evenh.versionmonitor.infrastructure.config;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import java.io.File;
import java.util.UUID;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttpClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestConfiguration {
  @Bean
  public RestTemplate okHttpRestTemplate(OkHttpClient client) {
    return new RestTemplate(new OkHttpClientHttpRequestFactory(client));
  }

  @Bean
  public OkHttpClient okHttpClient(Cache cache) {
    return new OkHttpClient().setCache(cache);
  }

  /**
   * Configures HTTP cache, mainly used for GitHub communication but can be reused.
   */
  @Bean
  public Cache cache(VersionmonitorConfiguration props) {
    final String randomFileName = UUID.randomUUID().toString();
    final File cacheDir = new File(System.getProperty("java.io.tmpdir"), randomFileName);
    final Integer cacheSize = props.getHttp().getCache().getCachesize();

    return new Cache(cacheDir, cacheSize * 1024 * 1024);
  }
}
