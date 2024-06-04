# DB logic testing PoC

[![CI](https://github.com/horothesun/db-logic-testing-poc/actions/workflows/ci.yml/badge.svg)](https://github.com/horothesun/db-logic-testing-poc/actions/workflows/ci.yml)
[![Renovate enabled](https://img.shields.io/badge/renovate-enabled-brightgreen.svg?style=flat-square)](https://renovatebot.com)
[![Mergify enabled](https://img.shields.io/badge/Mergify-enabled-success.svg?style=flat-square&logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAAAXNSR0IArs4c6QAAAAlwSFlzAAALEwAACxMBAJqcGAAABCRpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IlhNUCBDb3JlIDUuNC4wIj4KICAgPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4KICAgICAgPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIKICAgICAgICAgICAgeG1sbnM6dGlmZj0iaHR0cDovL25zLmFkb2JlLmNvbS90aWZmLzEuMC8iCiAgICAgICAgICAgIHhtbG5zOmV4aWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20vZXhpZi8xLjAvIgogICAgICAgICAgICB4bWxuczpkYz0iaHR0cDovL3B1cmwub3JnL2RjL2VsZW1lbnRzLzEuMS8iCiAgICAgICAgICAgIHhtbG5zOnhtcD0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLyI+CiAgICAgICAgIDx0aWZmOlJlc29sdXRpb25Vbml0PjI8L3RpZmY6UmVzb2x1dGlvblVuaXQ+CiAgICAgICAgIDx0aWZmOkNvbXByZXNzaW9uPjA8L3RpZmY6Q29tcHJlc3Npb24+CiAgICAgICAgIDx0aWZmOlhSZXNvbHV0aW9uPjcyPC90aWZmOlhSZXNvbHV0aW9uPgogICAgICAgICA8dGlmZjpPcmllbnRhdGlvbj4xPC90aWZmOk9yaWVudGF0aW9uPgogICAgICAgICA8dGlmZjpZUmVzb2x1dGlvbj43MjwvdGlmZjpZUmVzb2x1dGlvbj4KICAgICAgICAgPGV4aWY6UGl4ZWxYRGltZW5zaW9uPjMyPC9leGlmOlBpeGVsWERpbWVuc2lvbj4KICAgICAgICAgPGV4aWY6Q29sb3JTcGFjZT4xPC9leGlmOkNvbG9yU3BhY2U+CiAgICAgICAgIDxleGlmOlBpeGVsWURpbWVuc2lvbj4zMjwvZXhpZjpQaXhlbFlEaW1lbnNpb24+CiAgICAgICAg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)](https://mergify.com)
[![Scala](https://img.shields.io/badge/Scala-3-%23DC322F?style=flat&labelColor=%23383838&logo=Scala&logoColor=%23DC322F&logoWidth=12&cacheSeconds=3600)](https://www.scala-lang.org/)

Proof of concept on how to test some logic defined in your DB (e.g. `pure_db_logic(a int)`).

In order to demonstrate the integration with a DB via JDBC, the most external script (`scripts/integration_tests.sh`)
spins up a dockerized Postgres DB instance, initializes it with the function defined in `schema.sql` and
runs the test by connecting to the dockerized DB and checking the `SELECT pure_db_logic(123)` result.
