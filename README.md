# tree-model-system
Web application that allows creating and manipulating tree structures with complex nodes

# start

To start application use `gradlew clean build runAll`

Also `angular` component was hardcoded to use `HELLO_ID` for the dialog so in order to page
`Single Dialog Item` to work you should run that `Cypher` query in Neo4J browser

    CREATE(n:DialogLine { lineId: 'HELLO_ID', text: 'Hello, Friend'})

