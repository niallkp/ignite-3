/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.internal.sql.api;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.apache.ignite.sql.Statement;
import org.apache.ignite.sql.Statement.StatementBuilder;

/**
 * Statement builder.
 */
class StatementBuilderImpl implements StatementBuilder {
    /** Query. */
    private String query;

    /** Default schema. */
    private String defaultSchema;

    /** Query timeout. */
    private Long queryTimeoutMs;

    /** Page size. */
    private Integer pageSize;

    private ZoneId zoneId = ZoneOffset.UTC;

    /** {@inheritDoc} */
    @Override
    public String query() {
        return query;
    }

    /** {@inheritDoc} */
    @Override
    public StatementBuilder query(String sql) {
        query = sql;

        return this;
    }

    /** {@inheritDoc} */
    @Override
    public long queryTimeout(TimeUnit timeUnit) {
        Objects.requireNonNull(timeUnit);

        return timeUnit.convert(queryTimeoutMs == null ? 0 : queryTimeoutMs, TimeUnit.MILLISECONDS);
    }

    /** {@inheritDoc} */
    @Override
    public StatementBuilder queryTimeout(long timeout, TimeUnit timeUnit) {
        Objects.requireNonNull(timeUnit);

        queryTimeoutMs = TimeUnit.MILLISECONDS.convert(timeout, timeUnit);

        return this;
    }

    /** {@inheritDoc} */
    @Override
    public String defaultSchema() {
        return defaultSchema;
    }

    /** {@inheritDoc} */
    @Override
    public StatementBuilder defaultSchema(String schema) {
        defaultSchema = schema;

        return this;
    }

    /** {@inheritDoc} */
    @Override
    public int pageSize() {
        return pageSize == null ? 0 : pageSize;
    }

    /** {@inheritDoc} */
    @Override
    public StatementBuilder pageSize(int pageSize) {
        this.pageSize = pageSize;

        return this;
    }


    /** {@inheritDoc} */
    @Override
    public ZoneId timeZoneId() {
        return zoneId;
    }

    /** {@inheritDoc} */
    @Override
    public StatementBuilder timeZoneId(ZoneId zoneId) {
        this.zoneId = Objects.requireNonNull(zoneId);

        return this;
    }

    /** {@inheritDoc} */
    @Override
    public Statement build() {
        // TODO https://issues.apache.org/jira/browse/IGNITE-18647
        return new StatementImpl(query);
    }
}
