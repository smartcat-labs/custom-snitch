## Custom Snitch

This is maven project with custom implementation of Cassandra Snitch as showcase how to pack it up and build jar which can be deployed to Cassandra lib folder.

### Installation

1. clone this repo with `git clone git@github.com:smartcat-labs/custom-snitch.git`
2. change version of Cassandra you use in `pom.xml` (in properties section you have `version.cassandra` and put there your version)
3. either change `SmartCatSnitch` or add your own custom implementation of Cassandra Snitch
4. run `mvn clean install` which will create `custom-snitch-0.1.0.jar` in `target` folder
5. copy `custom-snitch-0.1.0.jar` to lib folder of your Cassandra instance (`$CASSANDRA_HOME/lib`) which will be loaded to classpath when Cassandra starts
6. change `cassandra.yaml` to use custom implementation of Snitch (`endpoint_snitch: io.smartcat.SmartCatSnitch`), provide full package name, since name only snitch (like `SimpleSnitch`) must be located in `org.apache.cassandra.locator`
7. restart Cassandra service and it will start using custom Snitch
