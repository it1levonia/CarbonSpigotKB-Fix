#!/usr/bin/env bash
set -e
cd "$(dirname "$0")"
java -version
mvn -U clean package -DskipTests
echo "Build finished. Check Carbon-Server/target/."
