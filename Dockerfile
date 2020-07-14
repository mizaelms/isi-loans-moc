FROM docker-enterprise-prod.artifactrepository.citigroup.net/cate-citicloud-java/oracle-jre-rhel7:1.8.0_211o_2

LABEL maintainer="Omer Kornitz <ok55827@imceu.eu.ssmb.com>"

WORKDIR /app
COPY target/isiloans.jar ./isiloans.jar

# OpenShift picks a random UID at run-time. Image must be able to run as any user.
RUN chmod g+rwx -R .

CMD ["java", "-jar", "isiloans.jar"]