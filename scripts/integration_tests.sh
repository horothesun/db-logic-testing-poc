#!/bin/bash

export POSTGRES_VERSION="16.3-alpine3.20"
scripts/test_db_up.sh

scala-cli test Main.scala integration
TESTS_EXIT_CODE="$?"

scripts/test_db_down.sh

exit "${TESTS_EXIT_CODE}"
