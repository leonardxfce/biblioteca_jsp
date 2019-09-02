#!/usr/bin/env bash
mvn package && java -jar target/dependency/webapp-runner.jar target/*.war