package io.ddf2.bigquery.handlers;

import io.ddf2.DDFException;
import io.ddf2.IDDF;
import io.ddf2.analytics.AggregateTypes;

import java.util.List;

/**
 * Created by sangdn on 1/24/16.
 */
public class AggregationHandler implements io.ddf2.handlers.IAggregationHandler{
    @Override
    public IDDF getDDF() {
        return null;
    }

    @Override
    public double computeCorrelation(String columnA, String columnB) throws DDFException {
        return 0;
    }

    @Override
    public AggregateTypes.AggregationResult aggregate(List<AggregateTypes.AggregateField> fields) throws DDFException {
        return null;
    }

    @Override
    public AggregateTypes.AggregationResult aggregate(String aggregate) throws DDFException {
        return null;
    }

    @Override
    public AggregateTypes.AggregationResult xtabs(List<AggregateTypes.AggregateField> fields) throws DDFException {
        return null;
    }

    @Override
    public IDDF groupBy(List<String> groupedColumns, List<String> aggregateFunctions) throws DDFException {
        return null;
    }

    @Override
    public double aggregateOnColumn(AggregateTypes.AggregateFunction function, String col) throws DDFException {
        return 0;
    }

    @Override
    public IDDF agg(List<String> aggregateFunctions) throws DDFException {
        return null;
    }

    @Override
    public IDDF groupBy(List<String> groupedColumns) {
        return null;
    }
}
