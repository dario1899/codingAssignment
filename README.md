Coding assignment

Tool for reading log file and adding found events to db.

TODOs:
- tests
- exceptions
- json validation



example logfile.txt
{"id":"gmrc1","state":"STARTED","timestamp":"1491377495213"}
{"id":"gmrc2","state":"STARTED","timestamp":"1491377495218"}
{"id":"gmrc1","state":"FINISHED","timestamp":"1491377495219"}
{"id":"gmrc3","state":"FINISHED","timestamp":"1491377495218"}
{"id":"gmrc2","state":"FINISHED","timestamp":"1491377495225"}
{"id":"gmrc3","state":"STARTED","timestamp":"1491377495216"}
{"id":"gmrc4","state":"STARTED","timestamp":"1491377495229"}
{"id":"gmrc5","state":"STARTED","timestamp":"1491377495221"}
{"id":"gmrc4","state":"FINISHED","timestamp":"1491377495238"}
{"id":"gmrc5","state":"FINISHED","timestamp":"1491377495223"}
{"id":"gmrcX","state":"STARTED","timestamp":"1491377495221"}
{"id":"gmrcX","state":"FINISHED","timestamp":"1491377495229"}
{"id":"gmrc8","state":"STARTED","type":"APPLICATION_LOG","host":"12345","timestamp":"1491377495221"}
{"id":"gmrc8","state":"FINISHED","type":"APPLICATION_LOG","host":"12345","timestamp":"1491377495229"}