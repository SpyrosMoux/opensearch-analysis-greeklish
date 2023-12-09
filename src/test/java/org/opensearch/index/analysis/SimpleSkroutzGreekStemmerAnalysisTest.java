package org.opensearch.index.analysis;

import org.opensearch.common.settings.Settings;
import org.opensearch.core.index.Index;
import org.opensearch.plugin.analysis.greeklish.GreeklishPlugin;
import org.opensearch.test.OpenSearchTestCase;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.instanceOf;

public class SimpleSkroutzGreekStemmerAnalysisTest extends OpenSearchTestCase {
  @Test
  public void testSkroutzGreekStemmerAnalysis() throws IOException {
    TestAnalysis analysis = createTestAnalysis(new Index("test", "_na_"),
      Settings.EMPTY, new GreeklishPlugin());

    TokenFilterFactory filterFactory = analysis.tokenFilter.get
      ("skroutz_greeklish");
    assertThat(filterFactory, instanceOf(GreeklishTokenFilterFactory.class));
  }
}
