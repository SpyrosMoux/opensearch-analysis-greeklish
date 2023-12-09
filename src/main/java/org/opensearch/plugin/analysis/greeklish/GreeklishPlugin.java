package org.opensearch.plugin.analysis.greeklish;

import org.opensearch.indices.analysis.AnalysisModule.AnalysisProvider;
import org.opensearch.index.analysis.TokenFilterFactory;
import org.opensearch.plugins.AnalysisPlugin;
import org.opensearch.plugins.Plugin;

import org.opensearch.index.analysis.GreeklishTokenFilterFactory;

import java.util.Map;

import static java.util.Collections.singletonMap;

public class GreeklishPlugin extends Plugin implements AnalysisPlugin {

    // Use singletonMap to register our token filter,
    // since we only have one in our plugin.
    @Override
    public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
        return singletonMap("skroutz_greeklish",
                GreeklishTokenFilterFactory::new);
    }
}
