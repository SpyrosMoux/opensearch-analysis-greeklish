package org.opensearch.index.analysis;

import org.apache.lucene.analysis.TokenStream;
import org.opensearch.common.inject.Inject;
import org.opensearch.common.inject.assistedinject.Assisted;
import org.opensearch.common.settings.Settings;

import org.opensearch.env.Environment;
import org.opensearch.index.IndexSettings;
import org.opensearch.index.analysis.AbstractTokenFilterFactory;

public class GreeklishTokenFilterFactory  extends AbstractTokenFilterFactory {
	private final int maxExpansions;
	private final boolean generateGreekVariants;

	@Inject
	public GreeklishTokenFilterFactory(IndexSettings indexSettings,
					   Environment env,
					   @Assisted String name,
					   @Assisted Settings settings) {

      		super(indexSettings, name, settings);
            	this.maxExpansions = settings.getAsInt("max_expansions", 20);
            	this.generateGreekVariants = settings.getAsBoolean("greek_variants", true);
	}

	@Override
	public TokenStream create(TokenStream tokenStream) {
		return new GreeklishTokenFilter(tokenStream, maxExpansions, generateGreekVariants);
    }

}
