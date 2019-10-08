#!/usr/bin/env bash
mvn package -DskipTests && java -jar target/dependency/webapp-runner.jar target/*.war