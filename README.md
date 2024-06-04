# DB logic testing PoC

[![CI](https://github.com/horothesun/db-logic-testing-poc/actions/workflows/ci.yml/badge.svg)](https://github.com/horothesun/db-logic-testing-poc/actions/workflows/ci.yml)

Proof of concept on how to test some logic defined in your DB (e.g. `pure_db_logic(a int)`).

In order to demonstrate the integration with a DB via JDBC, the most external script (`scripts/integration_tests.sh `)
spins up a dockerized Postgres DB instance, initializes it with the function defined in `schema.sql` and
runs the test by connecting to the dockerized DB and checking the `SELECT pure_db_logic(123)` result.
