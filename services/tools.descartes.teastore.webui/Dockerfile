FROM descartesresearch/teastore-base:latest
MAINTAINER Chair of Software Engineering <se2-it@informatik.uni-wuerzburg.de>

COPY target/*.war /usr/local/tomcat/webapps/
RUN mkdir -p /usr/local/tomcat/webapps/ROOT
ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005
CMD java -jar /usr/local/tomcat/bin/dockermemoryconfigurator.jar ${TOMCAT_HEAP_MEM_PERCENTAGE}; /usr/local/tomcat/bin/start.sh && echo '<% response.sendRedirect("/tools.descartes.teastore.webui/"); %>' > /usr/local/tomcat/webapps/ROOT/index.jsp && /usr/local/tomcat/bin/catalina.sh run