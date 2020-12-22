package com.github.lburgazzoli.camel.dsl.yaml.common.deserializers;

import com.github.lburgazzoli.camel.dsl.yaml.common.YamlDeserializerResolver;
import java.lang.Override;
import java.lang.String;
import org.snakeyaml.engine.v2.api.ConstructNode;

public final class EndpointProducerDeserializersResolver implements YamlDeserializerResolver {
    @Override
    public int getOrder() {
        return YamlDeserializerResolver.ORDER_LOWEST;
    }

    @Override
    public ConstructNode resolve(String id) {
        switch(id) {
            case "activemq": return new EndpointProducerDeserializers.Activemq();
            case "ahc": return new EndpointProducerDeserializers.Ahc();
            case "ahc-ws": return new EndpointProducerDeserializers.AhcWs();
            case "ahc-wss": return new EndpointProducerDeserializers.AhcWss();
            case "amqp": return new EndpointProducerDeserializers.Amqp();
            case "apns": return new EndpointProducerDeserializers.Apns();
            case "arangodb": return new EndpointProducerDeserializers.Arangodb();
            case "as2": return new EndpointProducerDeserializers.As2();
            case "asterisk": return new EndpointProducerDeserializers.Asterisk();
            case "atlasmap": return new EndpointProducerDeserializers.Atlasmap();
            case "atmos": return new EndpointProducerDeserializers.Atmos();
            case "atmosphere-websocket": return new EndpointProducerDeserializers.AtmosphereWebsocket();
            case "atomix-map": return new EndpointProducerDeserializers.AtomixMap();
            case "atomix-messaging": return new EndpointProducerDeserializers.AtomixMessaging();
            case "atomix-multimap": return new EndpointProducerDeserializers.AtomixMultimap();
            case "atomix-queue": return new EndpointProducerDeserializers.AtomixQueue();
            case "atomix-set": return new EndpointProducerDeserializers.AtomixSet();
            case "atomix-value": return new EndpointProducerDeserializers.AtomixValue();
            case "avro": return new EndpointProducerDeserializers.Avro();
            case "aws-cw": return new EndpointProducerDeserializers.AwsCw();
            case "aws-ddb": return new EndpointProducerDeserializers.AwsDdb();
            case "aws-ec2": return new EndpointProducerDeserializers.AwsEc2();
            case "aws-ecs": return new EndpointProducerDeserializers.AwsEcs();
            case "aws-eks": return new EndpointProducerDeserializers.AwsEks();
            case "aws-iam": return new EndpointProducerDeserializers.AwsIam();
            case "aws-s3": return new EndpointProducerDeserializers.AwsS3();
            case "aws-swf": return new EndpointProducerDeserializers.AwsSwf();
            case "aws2-athena": return new EndpointProducerDeserializers.Aws2Athena();
            case "aws2-cw": return new EndpointProducerDeserializers.Aws2Cw();
            case "aws2-ddb": return new EndpointProducerDeserializers.Aws2Ddb();
            case "aws2-ec2": return new EndpointProducerDeserializers.Aws2Ec2();
            case "aws2-ecs": return new EndpointProducerDeserializers.Aws2Ecs();
            case "aws2-eks": return new EndpointProducerDeserializers.Aws2Eks();
            case "aws2-eventbridge": return new EndpointProducerDeserializers.Aws2Eventbridge();
            case "aws2-iam": return new EndpointProducerDeserializers.Aws2Iam();
            case "aws2-kinesis": return new EndpointProducerDeserializers.Aws2Kinesis();
            case "aws2-kinesis-firehose": return new EndpointProducerDeserializers.Aws2KinesisFirehose();
            case "aws2-kms": return new EndpointProducerDeserializers.Aws2Kms();
            case "aws2-lambda": return new EndpointProducerDeserializers.Aws2Lambda();
            case "aws2-mq": return new EndpointProducerDeserializers.Aws2Mq();
            case "aws2-msk": return new EndpointProducerDeserializers.Aws2Msk();
            case "aws2-s3": return new EndpointProducerDeserializers.Aws2S3();
            case "aws2-ses": return new EndpointProducerDeserializers.Aws2Ses();
            case "aws2-sns": return new EndpointProducerDeserializers.Aws2Sns();
            case "aws2-sqs": return new EndpointProducerDeserializers.Aws2Sqs();
            case "aws2-sts": return new EndpointProducerDeserializers.Aws2Sts();
            case "aws2-translate": return new EndpointProducerDeserializers.Aws2Translate();
            case "azure-blob": return new EndpointProducerDeserializers.AzureBlob();
            case "azure-eventhubs": return new EndpointProducerDeserializers.AzureEventhubs();
            case "azure-queue": return new EndpointProducerDeserializers.AzureQueue();
            case "azure-storage-blob": return new EndpointProducerDeserializers.AzureStorageBlob();
            case "azure-storage-datalake": return new EndpointProducerDeserializers.AzureStorageDatalake();
            case "azure-storage-queue": return new EndpointProducerDeserializers.AzureStorageQueue();
            case "bean": return new EndpointProducerDeserializers.Bean();
            case "bean-validator": return new EndpointProducerDeserializers.BeanValidator();
            case "beanstalk": return new EndpointProducerDeserializers.Beanstalk();
            case "bonita": return new EndpointProducerDeserializers.Bonita();
            case "box": return new EndpointProducerDeserializers.Box();
            case "braintree": return new EndpointProducerDeserializers.Braintree();
            case "browse": return new EndpointProducerDeserializers.Browse();
            case "caffeine-cache": return new EndpointProducerDeserializers.CaffeineCache();
            case "caffeine-loadcache": return new EndpointProducerDeserializers.CaffeineLoadcache();
            case "chatscript": return new EndpointProducerDeserializers.Chatscript();
            case "chunk": return new EndpointProducerDeserializers.Chunk();
            case "class": return new EndpointProducerDeserializers.Class();
            case "cm-sms": return new EndpointProducerDeserializers.CmSms();
            case "cmis": return new EndpointProducerDeserializers.Cmis();
            case "coap": return new EndpointProducerDeserializers.Coap();
            case "coap+tcp": return new EndpointProducerDeserializers.CoapTcp();
            case "coaps": return new EndpointProducerDeserializers.Coaps();
            case "coaps+tcp": return new EndpointProducerDeserializers.CoapsTcp();
            case "cometd": return new EndpointProducerDeserializers.Cometd();
            case "cometds": return new EndpointProducerDeserializers.Cometds();
            case "consul": return new EndpointProducerDeserializers.Consul();
            case "controlbus": return new EndpointProducerDeserializers.Controlbus();
            case "corda": return new EndpointProducerDeserializers.Corda();
            case "couchbase": return new EndpointProducerDeserializers.Couchbase();
            case "couchdb": return new EndpointProducerDeserializers.Couchdb();
            case "cql": return new EndpointProducerDeserializers.Cql();
            case "crypto": return new EndpointProducerDeserializers.Crypto();
            case "crypto-cms": return new EndpointProducerDeserializers.CryptoCms();
            case "cxf": return new EndpointProducerDeserializers.Cxf();
            case "cxfrs": return new EndpointProducerDeserializers.Cxfrs();
            case "dataformat": return new EndpointProducerDeserializers.Dataformat();
            case "dataset": return new EndpointProducerDeserializers.Dataset();
            case "dataset-test": return new EndpointProducerDeserializers.DatasetTest();
            case "digitalocean": return new EndpointProducerDeserializers.Digitalocean();
            case "direct": return new EndpointProducerDeserializers.Direct();
            case "direct-vm": return new EndpointProducerDeserializers.DirectVm();
            case "disruptor": return new EndpointProducerDeserializers.Disruptor();
            case "disruptor-vm": return new EndpointProducerDeserializers.DisruptorVm();
            case "djl": return new EndpointProducerDeserializers.Djl();
            case "dns": return new EndpointProducerDeserializers.Dns();
            case "docker": return new EndpointProducerDeserializers.Docker();
            case "dozer": return new EndpointProducerDeserializers.Dozer();
            case "drill": return new EndpointProducerDeserializers.Drill();
            case "dropbox": return new EndpointProducerDeserializers.Dropbox();
            case "ehcache": return new EndpointProducerDeserializers.Ehcache();
            case "elasticsearch-rest": return new EndpointProducerDeserializers.ElasticsearchRest();
            case "elsql": return new EndpointProducerDeserializers.Elsql();
            case "etcd-keys": return new EndpointProducerDeserializers.EtcdKeys();
            case "etcd-stats": return new EndpointProducerDeserializers.EtcdStats();
            case "exec": return new EndpointProducerDeserializers.Exec();
            case "facebook": return new EndpointProducerDeserializers.Facebook();
            case "fhir": return new EndpointProducerDeserializers.Fhir();
            case "file": return new EndpointProducerDeserializers.File();
            case "flatpack": return new EndpointProducerDeserializers.Flatpack();
            case "flink": return new EndpointProducerDeserializers.Flink();
            case "fop": return new EndpointProducerDeserializers.Fop();
            case "freemarker": return new EndpointProducerDeserializers.Freemarker();
            case "ftp": return new EndpointProducerDeserializers.Ftp();
            case "ftps": return new EndpointProducerDeserializers.Ftps();
            case "ganglia": return new EndpointProducerDeserializers.Ganglia();
            case "geocoder": return new EndpointProducerDeserializers.Geocoder();
            case "git": return new EndpointProducerDeserializers.Git();
            case "github": return new EndpointProducerDeserializers.Github();
            case "google-bigquery": return new EndpointProducerDeserializers.GoogleBigquery();
            case "google-bigquery-sql": return new EndpointProducerDeserializers.GoogleBigquerySql();
            case "google-calendar": return new EndpointProducerDeserializers.GoogleCalendar();
            case "google-drive": return new EndpointProducerDeserializers.GoogleDrive();
            case "google-mail": return new EndpointProducerDeserializers.GoogleMail();
            case "google-pubsub": return new EndpointProducerDeserializers.GooglePubsub();
            case "google-sheets": return new EndpointProducerDeserializers.GoogleSheets();
            case "google-storage": return new EndpointProducerDeserializers.GoogleStorage();
            case "gora": return new EndpointProducerDeserializers.Gora();
            case "grape": return new EndpointProducerDeserializers.Grape();
            case "graphql": return new EndpointProducerDeserializers.Graphql();
            case "grpc": return new EndpointProducerDeserializers.Grpc();
            case "guava-eventbus": return new EndpointProducerDeserializers.GuavaEventbus();
            case "hazelcast-atomicvalue": return new EndpointProducerDeserializers.HazelcastAtomicvalue();
            case "hazelcast-list": return new EndpointProducerDeserializers.HazelcastList();
            case "hazelcast-map": return new EndpointProducerDeserializers.HazelcastMap();
            case "hazelcast-multimap": return new EndpointProducerDeserializers.HazelcastMultimap();
            case "hazelcast-queue": return new EndpointProducerDeserializers.HazelcastQueue();
            case "hazelcast-replicatedmap": return new EndpointProducerDeserializers.HazelcastReplicatedmap();
            case "hazelcast-ringbuffer": return new EndpointProducerDeserializers.HazelcastRingbuffer();
            case "hazelcast-seda": return new EndpointProducerDeserializers.HazelcastSeda();
            case "hazelcast-set": return new EndpointProducerDeserializers.HazelcastSet();
            case "hazelcast-topic": return new EndpointProducerDeserializers.HazelcastTopic();
            case "hbase": return new EndpointProducerDeserializers.Hbase();
            case "hdfs": return new EndpointProducerDeserializers.Hdfs();
            case "http": return new EndpointProducerDeserializers.Http();
            case "https": return new EndpointProducerDeserializers.Https();
            case "hwcloud-smn": return new EndpointProducerDeserializers.HwcloudSmn();
            case "iec60870-client": return new EndpointProducerDeserializers.Iec60870Client();
            case "iec60870-server": return new EndpointProducerDeserializers.Iec60870Server();
            case "ignite-cache": return new EndpointProducerDeserializers.IgniteCache();
            case "ignite-compute": return new EndpointProducerDeserializers.IgniteCompute();
            case "ignite-idgen": return new EndpointProducerDeserializers.IgniteIdgen();
            case "ignite-messaging": return new EndpointProducerDeserializers.IgniteMessaging();
            case "ignite-queue": return new EndpointProducerDeserializers.IgniteQueue();
            case "ignite-set": return new EndpointProducerDeserializers.IgniteSet();
            case "imap": return new EndpointProducerDeserializers.Imap();
            case "imaps": return new EndpointProducerDeserializers.Imaps();
            case "infinispan": return new EndpointProducerDeserializers.Infinispan();
            case "infinispan-embedded": return new EndpointProducerDeserializers.InfinispanEmbedded();
            case "influxdb": return new EndpointProducerDeserializers.Influxdb();
            case "iota": return new EndpointProducerDeserializers.Iota();
            case "ipfs": return new EndpointProducerDeserializers.Ipfs();
            case "irc": return new EndpointProducerDeserializers.Irc();
            case "ironmq": return new EndpointProducerDeserializers.Ironmq();
            case "jbpm": return new EndpointProducerDeserializers.Jbpm();
            case "jcache": return new EndpointProducerDeserializers.Jcache();
            case "jclouds": return new EndpointProducerDeserializers.Jclouds();
            case "jcr": return new EndpointProducerDeserializers.Jcr();
            case "jdbc": return new EndpointProducerDeserializers.Jdbc();
            case "jgroups": return new EndpointProducerDeserializers.Jgroups();
            case "jgroups-raft": return new EndpointProducerDeserializers.JgroupsRaft();
            case "jing": return new EndpointProducerDeserializers.Jing();
            case "jira": return new EndpointProducerDeserializers.Jira();
            case "jms": return new EndpointProducerDeserializers.Jms();
            case "jolt": return new EndpointProducerDeserializers.Jolt();
            case "jooq": return new EndpointProducerDeserializers.Jooq();
            case "jpa": return new EndpointProducerDeserializers.Jpa();
            case "jslt": return new EndpointProducerDeserializers.Jslt();
            case "json-validator": return new EndpointProducerDeserializers.JsonValidator();
            case "jsonata": return new EndpointProducerDeserializers.Jsonata();
            case "jt400": return new EndpointProducerDeserializers.Jt400();
            case "kafka": return new EndpointProducerDeserializers.Kafka();
            case "kamelet": return new EndpointProducerDeserializers.Kamelet();
            case "kubernetes-config-maps": return new EndpointProducerDeserializers.KubernetesConfigMaps();
            case "kubernetes-custom-resources": return new EndpointProducerDeserializers.KubernetesCustomResources();
            case "kubernetes-deployments": return new EndpointProducerDeserializers.KubernetesDeployments();
            case "kubernetes-hpa": return new EndpointProducerDeserializers.KubernetesHpa();
            case "kubernetes-job": return new EndpointProducerDeserializers.KubernetesJob();
            case "kubernetes-namespaces": return new EndpointProducerDeserializers.KubernetesNamespaces();
            case "kubernetes-nodes": return new EndpointProducerDeserializers.KubernetesNodes();
            case "kubernetes-persistent-volumes": return new EndpointProducerDeserializers.KubernetesPersistentVolumes();
            case "kubernetes-persistent-volumes-claims": return new EndpointProducerDeserializers.KubernetesPersistentVolumesClaims();
            case "kubernetes-pods": return new EndpointProducerDeserializers.KubernetesPods();
            case "kubernetes-replication-controllers": return new EndpointProducerDeserializers.KubernetesReplicationControllers();
            case "kubernetes-resources-quota": return new EndpointProducerDeserializers.KubernetesResourcesQuota();
            case "kubernetes-secrets": return new EndpointProducerDeserializers.KubernetesSecrets();
            case "kubernetes-service-accounts": return new EndpointProducerDeserializers.KubernetesServiceAccounts();
            case "kubernetes-services": return new EndpointProducerDeserializers.KubernetesServices();
            case "kudu": return new EndpointProducerDeserializers.Kudu();
            case "language": return new EndpointProducerDeserializers.Language();
            case "ldap": return new EndpointProducerDeserializers.Ldap();
            case "ldif": return new EndpointProducerDeserializers.Ldif();
            case "log": return new EndpointProducerDeserializers.Log();
            case "lpr": return new EndpointProducerDeserializers.Lpr();
            case "lucene": return new EndpointProducerDeserializers.Lucene();
            case "metrics": return new EndpointProducerDeserializers.Metrics();
            case "micrometer": return new EndpointProducerDeserializers.Micrometer();
            case "microprofile-metrics": return new EndpointProducerDeserializers.MicroprofileMetrics();
            case "milo-client": return new EndpointProducerDeserializers.MiloClient();
            case "milo-server": return new EndpointProducerDeserializers.MiloServer();
            case "mina": return new EndpointProducerDeserializers.Mina();
            case "minio": return new EndpointProducerDeserializers.Minio();
            case "mllp": return new EndpointProducerDeserializers.Mllp();
            case "mock": return new EndpointProducerDeserializers.Mock();
            case "mongodb": return new EndpointProducerDeserializers.Mongodb();
            case "mongodb-gridfs": return new EndpointProducerDeserializers.MongodbGridfs();
            case "msv": return new EndpointProducerDeserializers.Msv();
            case "mustache": return new EndpointProducerDeserializers.Mustache();
            case "mvel": return new EndpointProducerDeserializers.Mvel();
            case "mybatis": return new EndpointProducerDeserializers.Mybatis();
            case "mybatis-bean": return new EndpointProducerDeserializers.MybatisBean();
            case "nagios": return new EndpointProducerDeserializers.Nagios();
            case "nats": return new EndpointProducerDeserializers.Nats();
            case "netty": return new EndpointProducerDeserializers.Netty();
            case "netty-http": return new EndpointProducerDeserializers.NettyHttp();
            case "nitrite": return new EndpointProducerDeserializers.Nitrite();
            case "nsq": return new EndpointProducerDeserializers.Nsq();
            case "oaipmh": return new EndpointProducerDeserializers.Oaipmh();
            case "olingo2": return new EndpointProducerDeserializers.Olingo2();
            case "olingo4": return new EndpointProducerDeserializers.Olingo4();
            case "openshift-build-configs": return new EndpointProducerDeserializers.OpenshiftBuildConfigs();
            case "openshift-builds": return new EndpointProducerDeserializers.OpenshiftBuilds();
            case "openstack-cinder": return new EndpointProducerDeserializers.OpenstackCinder();
            case "openstack-glance": return new EndpointProducerDeserializers.OpenstackGlance();
            case "openstack-keystone": return new EndpointProducerDeserializers.OpenstackKeystone();
            case "openstack-neutron": return new EndpointProducerDeserializers.OpenstackNeutron();
            case "openstack-nova": return new EndpointProducerDeserializers.OpenstackNova();
            case "openstack-swift": return new EndpointProducerDeserializers.OpenstackSwift();
            case "optaplanner": return new EndpointProducerDeserializers.Optaplanner();
            case "paho": return new EndpointProducerDeserializers.Paho();
            case "paho-mqtt5": return new EndpointProducerDeserializers.PahoMqtt5();
            case "pdf": return new EndpointProducerDeserializers.Pdf();
            case "pgevent": return new EndpointProducerDeserializers.Pgevent();
            case "pop3": return new EndpointProducerDeserializers.Pop3();
            case "pop3s": return new EndpointProducerDeserializers.Pop3s();
            case "pubnub": return new EndpointProducerDeserializers.Pubnub();
            case "pulsar": return new EndpointProducerDeserializers.Pulsar();
            case "quickfix": return new EndpointProducerDeserializers.Quickfix();
            case "rabbitmq": return new EndpointProducerDeserializers.Rabbitmq();
            case "reactive-streams": return new EndpointProducerDeserializers.ReactiveStreams();
            case "ref": return new EndpointProducerDeserializers.Ref();
            case "rest": return new EndpointProducerDeserializers.Rest();
            case "rest-openapi": return new EndpointProducerDeserializers.RestOpenapi();
            case "rest-swagger": return new EndpointProducerDeserializers.RestSwagger();
            case "resteasy": return new EndpointProducerDeserializers.Resteasy();
            case "robotframework": return new EndpointProducerDeserializers.Robotframework();
            case "saga": return new EndpointProducerDeserializers.Saga();
            case "salesforce": return new EndpointProducerDeserializers.Salesforce();
            case "sap-netweaver": return new EndpointProducerDeserializers.SapNetweaver();
            case "schematron": return new EndpointProducerDeserializers.Schematron();
            case "scp": return new EndpointProducerDeserializers.Scp();
            case "seda": return new EndpointProducerDeserializers.Seda();
            case "servicenow": return new EndpointProducerDeserializers.Servicenow();
            case "sftp": return new EndpointProducerDeserializers.Sftp();
            case "sip": return new EndpointProducerDeserializers.Sip();
            case "sips": return new EndpointProducerDeserializers.Sips();
            case "sjms": return new EndpointProducerDeserializers.Sjms();
            case "sjms2": return new EndpointProducerDeserializers.Sjms2();
            case "slack": return new EndpointProducerDeserializers.Slack();
            case "smpp": return new EndpointProducerDeserializers.Smpp();
            case "smpps": return new EndpointProducerDeserializers.Smpps();
            case "smtp": return new EndpointProducerDeserializers.Smtp();
            case "smtps": return new EndpointProducerDeserializers.Smtps();
            case "snmp": return new EndpointProducerDeserializers.Snmp();
            case "solr": return new EndpointProducerDeserializers.Solr();
            case "solrCloud": return new EndpointProducerDeserializers.SolrCloud();
            case "solrs": return new EndpointProducerDeserializers.Solrs();
            case "soroush": return new EndpointProducerDeserializers.Soroush();
            case "spark": return new EndpointProducerDeserializers.Spark();
            case "splunk": return new EndpointProducerDeserializers.Splunk();
            case "splunk-hec": return new EndpointProducerDeserializers.SplunkHec();
            case "spring-batch": return new EndpointProducerDeserializers.SpringBatch();
            case "spring-event": return new EndpointProducerDeserializers.SpringEvent();
            case "spring-integration": return new EndpointProducerDeserializers.SpringIntegration();
            case "spring-ldap": return new EndpointProducerDeserializers.SpringLdap();
            case "spring-rabbitmq": return new EndpointProducerDeserializers.SpringRabbitmq();
            case "spring-redis": return new EndpointProducerDeserializers.SpringRedis();
            case "spring-ws": return new EndpointProducerDeserializers.SpringWs();
            case "sql": return new EndpointProducerDeserializers.Sql();
            case "sql-stored": return new EndpointProducerDeserializers.SqlStored();
            case "ssh": return new EndpointProducerDeserializers.Ssh();
            case "stax": return new EndpointProducerDeserializers.Stax();
            case "stitch": return new EndpointProducerDeserializers.Stitch();
            case "stomp": return new EndpointProducerDeserializers.Stomp();
            case "stream": return new EndpointProducerDeserializers.Stream();
            case "string-template": return new EndpointProducerDeserializers.StringTemplate();
            case "stub": return new EndpointProducerDeserializers.Stub();
            case "telegram": return new EndpointProducerDeserializers.Telegram();
            case "thrift": return new EndpointProducerDeserializers.Thrift();
            case "tika": return new EndpointProducerDeserializers.Tika();
            case "twilio": return new EndpointProducerDeserializers.Twilio();
            case "twitter-directmessage": return new EndpointProducerDeserializers.TwitterDirectmessage();
            case "twitter-search": return new EndpointProducerDeserializers.TwitterSearch();
            case "twitter-timeline": return new EndpointProducerDeserializers.TwitterTimeline();
            case "undertow": return new EndpointProducerDeserializers.Undertow();
            case "validator": return new EndpointProducerDeserializers.Validator();
            case "velocity": return new EndpointProducerDeserializers.Velocity();
            case "vertx": return new EndpointProducerDeserializers.Vertx();
            case "vertx-http": return new EndpointProducerDeserializers.VertxHttp();
            case "vertx-kafka": return new EndpointProducerDeserializers.VertxKafka();
            case "vertx-websocket": return new EndpointProducerDeserializers.VertxWebsocket();
            case "vm": return new EndpointProducerDeserializers.Vm();
            case "weather": return new EndpointProducerDeserializers.Weather();
            case "web3j": return new EndpointProducerDeserializers.Web3j();
            case "websocket": return new EndpointProducerDeserializers.Websocket();
            case "websocket-jsr356": return new EndpointProducerDeserializers.WebsocketJsr356();
            case "weka": return new EndpointProducerDeserializers.Weka();
            case "wordpress": return new EndpointProducerDeserializers.Wordpress();
            case "workday": return new EndpointProducerDeserializers.Workday();
            case "xchange": return new EndpointProducerDeserializers.Xchange();
            case "xj": return new EndpointProducerDeserializers.Xj();
            case "xmlsecurity-sign": return new EndpointProducerDeserializers.XmlsecuritySign();
            case "xmlsecurity-verify": return new EndpointProducerDeserializers.XmlsecurityVerify();
            case "xmpp": return new EndpointProducerDeserializers.Xmpp();
            case "xquery": return new EndpointProducerDeserializers.Xquery();
            case "xslt": return new EndpointProducerDeserializers.Xslt();
            case "xslt-saxon": return new EndpointProducerDeserializers.XsltSaxon();
            case "yammer": return new EndpointProducerDeserializers.Yammer();
            case "zendesk": return new EndpointProducerDeserializers.Zendesk();
            case "zookeeper": return new EndpointProducerDeserializers.Zookeeper();
        }
        return null;
    }
}