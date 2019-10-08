#!/usr/bin/env bash
mvn package -T 1C -Dmaven.test.skip -DskipTests && java -jar target/dependency/webapp-runner.jar target/*.war