package br.com.deimos.config;

import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;

@Component
public class CustomExceptionHandler extends DataFetcherExceptionResolverAdapter{

	@Override
	protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
		return GraphqlErrorBuilder.newError()
				.message(ex.getMessage())
				.path(env.getExecutionStepInfo().getPath())
				.location(env.getField().getSourceLocation())
				.build();
	}
}
