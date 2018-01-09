

# Maven

```
# displays phase, id, plugin, plugin's goal within a maven project
$ mvn fr.jcgay.maven.plugins:buildplan-maven-plugin:list

# show whole pom
$ mvn help:effective-pom

# available updates
mvn versions:display-plugin-updates

# plugin dependency
# `spotbugs-maven-plugin-3.1.1.jar` needs `maven-core-3.5.2.jar` -> it needs maven.3.5
mvn dependency:resolve-plugins
```

```
/boilerplate-maven$  mvn fr.jcgay.maven.plugins:buildplan-maven-plugin:list
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building boilerplate-maven 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- buildplan-maven-plugin:1.3:list (default-cli) @ boilerplate-maven ---
[INFO] Build Plan for boilerplate-maven:
-----------------------------------------------------------------------------------------------------------------
PLUGIN                   | PHASE                  | ID                                | GOAL
-----------------------------------------------------------------------------------------------------------------
maven-enforcer-plugin    | validate               | enforce-versions                  | enforce
maven-enforcer-plugin    | validate               | display-info                      | display-info
jacoco-maven-plugin      | initialize             | default-prepare-agent             | prepare-agent
maven-resources-plugin   | process-resources      | default-resources                 | resources
maven-compiler-plugin    | compile                | default-compile                   | compile
gmavenplus-plugin        | compile                | default                           | compile
maven-resources-plugin   | process-test-resources | default-testResources             | testResources
maven-compiler-plugin    | test-compile           | default-testCompile               | testCompile
gmavenplus-plugin        | test-compile           | default                           | testCompile
maven-surefire-plugin    | test                   | default-test                      | test
maven-war-plugin         | package                | default-war                       | war
spring-boot-maven-plugin | package                | default                           | repackage
maven-source-plugin      | package                | attach-sources                    | jar-no-fork
jacoco-maven-plugin      | pre-integration-test   | default-prepare-agent-integration | prepare-agent-integration
maven-failsafe-plugin    | integration-test       | default                           | integration-test
maven-failsafe-plugin    | verify                 | default                           | verify
jacoco-maven-plugin      | verify                 | default-report                    | report
jacoco-maven-plugin      | verify                 | default-report-integration        | report-integration
jacoco-maven-plugin      | verify                 | default-check                     | check
maven-pmd-plugin         | verify                 | default                           | check
maven-pmd-plugin         | verify                 | default                           | pmd
spotbugs-maven-plugin    | verify                 | default                           | check
maven-install-plugin     | install                | default-install                   | install
maven-deploy-plugin      | deploy                 | default-deploy                    | deploy
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 0.591 s
[INFO] Finished at: 2018-01-08T22:43:40-06:00
[INFO] Final Memory: 14M/245M
[INFO] ------------------------------------------------------------------------
```

Binding plugins' goals to  `phase` + `id`, a same plugin's goal can be executed twice when their ids are different, since `phase` + `id` is treated as the unique key.

## Plugins

* pre-check
  * maven-enforcer-plugin
    * requires system have a certain version of Java and Maven
* compile
  * gmavenplus-plugin
    * compile groovy codes
  * maven-compiler-plugin
    * specify a Java compile version
* test
  * maven-surefire-plugin
    * run unit tests with certain java files
  * maven-failsafe-plugin
    * run integration tests with certain java files (`*IT.java`)
* package
  * maven-war-plugin
    * exclue certain files from war file
    * springboot actually repackage the war file, so the war file generated here is rename to `*.war.original`
  * maven-source-plugin
    * attach source file in the artifact
* test coverage & code analysis
  * jacoco-maven-plugin
    * run coverage reports
    * fails if certain requirements are not met
    * reports can be found at `target/site/jacoco/index.html`
  * maven-pmd-plugin
    * run code analysis
    * fails if certain requirements are not met
    * reports can be found at `target/site/pmd.html`
  * spotbugs-maven-plugin
    * run code analysis
    * fails if certain requirements are not met
    * run `mvn spotbugs:gui` to show details