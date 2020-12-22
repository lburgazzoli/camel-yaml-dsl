package com.github.lburgazzoli.camel.dsl.yaml.common.deserializers;

import com.github.lburgazzoli.camel.dsl.yaml.common.YamlDeserializerSupport;

public final class EndpointConsumerDeserializers extends YamlDeserializerSupport {
    private EndpointConsumerDeserializers() {
    }

    public static final class Activemq extends EndpointDeserializers.From {
        public Activemq() {
            super("activemq");
        }
    }

    public static final class AhcWs extends EndpointDeserializers.From {
        public AhcWs() {
            super("ahc-ws");
        }
    }

    public static final class AhcWss extends EndpointDeserializers.From {
        public AhcWss() {
            super("ahc-wss");
        }
    }

    public static final class Amqp extends EndpointDeserializers.From {
        public Amqp() {
            super("amqp");
        }
    }

    public static final class Apns extends EndpointDeserializers.From {
        public Apns() {
            super("apns");
        }
    }

    public static final class As2 extends EndpointDeserializers.From {
        public As2() {
            super("as2");
        }
    }

    public static final class Asterisk extends EndpointDeserializers.From {
        public Asterisk() {
            super("asterisk");
        }
    }

    public static final class Atmos extends EndpointDeserializers.From {
        public Atmos() {
            super("atmos");
        }
    }

    public static final class AtmosphereWebsocket extends EndpointDeserializers.From {
        public AtmosphereWebsocket() {
            super("atmosphere-websocket");
        }
    }

    public static final class Atom extends EndpointDeserializers.From {
        public Atom() {
            super("atom");
        }
    }

    public static final class AtomixMap extends EndpointDeserializers.From {
        public AtomixMap() {
            super("atomix-map");
        }
    }

    public static final class AtomixMessaging extends EndpointDeserializers.From {
        public AtomixMessaging() {
            super("atomix-messaging");
        }
    }

    public static final class AtomixQueue extends EndpointDeserializers.From {
        public AtomixQueue() {
            super("atomix-queue");
        }
    }

    public static final class AtomixSet extends EndpointDeserializers.From {
        public AtomixSet() {
            super("atomix-set");
        }
    }

    public static final class AtomixValue extends EndpointDeserializers.From {
        public AtomixValue() {
            super("atomix-value");
        }
    }

    public static final class Avro extends EndpointDeserializers.From {
        public Avro() {
            super("avro");
        }
    }

    public static final class AwsDdbstream extends EndpointDeserializers.From {
        public AwsDdbstream() {
            super("aws-ddbstream");
        }
    }

    public static final class AwsS3 extends EndpointDeserializers.From {
        public AwsS3() {
            super("aws-s3");
        }
    }

    public static final class AwsSwf extends EndpointDeserializers.From {
        public AwsSwf() {
            super("aws-swf");
        }
    }

    public static final class Aws2Ddbstream extends EndpointDeserializers.From {
        public Aws2Ddbstream() {
            super("aws2-ddbstream");
        }
    }

    public static final class Aws2Kinesis extends EndpointDeserializers.From {
        public Aws2Kinesis() {
            super("aws2-kinesis");
        }
    }

    public static final class Aws2S3 extends EndpointDeserializers.From {
        public Aws2S3() {
            super("aws2-s3");
        }
    }

    public static final class Aws2Sqs extends EndpointDeserializers.From {
        public Aws2Sqs() {
            super("aws2-sqs");
        }
    }

    public static final class AzureBlob extends EndpointDeserializers.From {
        public AzureBlob() {
            super("azure-blob");
        }
    }

    public static final class AzureEventhubs extends EndpointDeserializers.From {
        public AzureEventhubs() {
            super("azure-eventhubs");
        }
    }

    public static final class AzureQueue extends EndpointDeserializers.From {
        public AzureQueue() {
            super("azure-queue");
        }
    }

    public static final class AzureStorageBlob extends EndpointDeserializers.From {
        public AzureStorageBlob() {
            super("azure-storage-blob");
        }
    }

    public static final class AzureStorageDatalake extends EndpointDeserializers.From {
        public AzureStorageDatalake() {
            super("azure-storage-datalake");
        }
    }

    public static final class AzureStorageQueue extends EndpointDeserializers.From {
        public AzureStorageQueue() {
            super("azure-storage-queue");
        }
    }

    public static final class Beanstalk extends EndpointDeserializers.From {
        public Beanstalk() {
            super("beanstalk");
        }
    }

    public static final class Box extends EndpointDeserializers.From {
        public Box() {
            super("box");
        }
    }

    public static final class Browse extends EndpointDeserializers.From {
        public Browse() {
            super("browse");
        }
    }

    public static final class Cmis extends EndpointDeserializers.From {
        public Cmis() {
            super("cmis");
        }
    }

    public static final class Coap extends EndpointDeserializers.From {
        public Coap() {
            super("coap");
        }
    }

    public static final class CoapTcp extends EndpointDeserializers.From {
        public CoapTcp() {
            super("coap+tcp");
        }
    }

    public static final class Coaps extends EndpointDeserializers.From {
        public Coaps() {
            super("coaps");
        }
    }

    public static final class CoapsTcp extends EndpointDeserializers.From {
        public CoapsTcp() {
            super("coaps+tcp");
        }
    }

    public static final class Cometd extends EndpointDeserializers.From {
        public Cometd() {
            super("cometd");
        }
    }

    public static final class Cometds extends EndpointDeserializers.From {
        public Cometds() {
            super("cometds");
        }
    }

    public static final class Consul extends EndpointDeserializers.From {
        public Consul() {
            super("consul");
        }
    }

    public static final class Corda extends EndpointDeserializers.From {
        public Corda() {
            super("corda");
        }
    }

    public static final class Couchbase extends EndpointDeserializers.From {
        public Couchbase() {
            super("couchbase");
        }
    }

    public static final class Couchdb extends EndpointDeserializers.From {
        public Couchdb() {
            super("couchdb");
        }
    }

    public static final class Cql extends EndpointDeserializers.From {
        public Cql() {
            super("cql");
        }
    }

    public static final class Cron extends EndpointDeserializers.From {
        public Cron() {
            super("cron");
        }
    }

    public static final class Cxf extends EndpointDeserializers.From {
        public Cxf() {
            super("cxf");
        }
    }

    public static final class Cxfrs extends EndpointDeserializers.From {
        public Cxfrs() {
            super("cxfrs");
        }
    }

    public static final class Dataset extends EndpointDeserializers.From {
        public Dataset() {
            super("dataset");
        }
    }

    public static final class DebeziumMongodb extends EndpointDeserializers.From {
        public DebeziumMongodb() {
            super("debezium-mongodb");
        }
    }

    public static final class DebeziumMysql extends EndpointDeserializers.From {
        public DebeziumMysql() {
            super("debezium-mysql");
        }
    }

    public static final class DebeziumPostgres extends EndpointDeserializers.From {
        public DebeziumPostgres() {
            super("debezium-postgres");
        }
    }

    public static final class DebeziumSqlserver extends EndpointDeserializers.From {
        public DebeziumSqlserver() {
            super("debezium-sqlserver");
        }
    }

    public static final class Direct extends EndpointDeserializers.From {
        public Direct() {
            super("direct");
        }
    }

    public static final class DirectVm extends EndpointDeserializers.From {
        public DirectVm() {
            super("direct-vm");
        }
    }

    public static final class Disruptor extends EndpointDeserializers.From {
        public Disruptor() {
            super("disruptor");
        }
    }

    public static final class DisruptorVm extends EndpointDeserializers.From {
        public DisruptorVm() {
            super("disruptor-vm");
        }
    }

    public static final class Docker extends EndpointDeserializers.From {
        public Docker() {
            super("docker");
        }
    }

    public static final class Dropbox extends EndpointDeserializers.From {
        public Dropbox() {
            super("dropbox");
        }
    }

    public static final class Ehcache extends EndpointDeserializers.From {
        public Ehcache() {
            super("ehcache");
        }
    }

    public static final class Elsql extends EndpointDeserializers.From {
        public Elsql() {
            super("elsql");
        }
    }

    public static final class EtcdStats extends EndpointDeserializers.From {
        public EtcdStats() {
            super("etcd-stats");
        }
    }

    public static final class EtcdWatch extends EndpointDeserializers.From {
        public EtcdWatch() {
            super("etcd-watch");
        }
    }

    public static final class Facebook extends EndpointDeserializers.From {
        public Facebook() {
            super("facebook");
        }
    }

    public static final class Fhir extends EndpointDeserializers.From {
        public Fhir() {
            super("fhir");
        }
    }

    public static final class File extends EndpointDeserializers.From {
        public File() {
            super("file");
        }
    }

    public static final class FileWatch extends EndpointDeserializers.From {
        public FileWatch() {
            super("file-watch");
        }
    }

    public static final class Flatpack extends EndpointDeserializers.From {
        public Flatpack() {
            super("flatpack");
        }
    }

    public static final class Ftp extends EndpointDeserializers.From {
        public Ftp() {
            super("ftp");
        }
    }

    public static final class Ftps extends EndpointDeserializers.From {
        public Ftps() {
            super("ftps");
        }
    }

    public static final class Git extends EndpointDeserializers.From {
        public Git() {
            super("git");
        }
    }

    public static final class Github extends EndpointDeserializers.From {
        public Github() {
            super("github");
        }
    }

    public static final class GoogleCalendar extends EndpointDeserializers.From {
        public GoogleCalendar() {
            super("google-calendar");
        }
    }

    public static final class GoogleCalendarStream extends EndpointDeserializers.From {
        public GoogleCalendarStream() {
            super("google-calendar-stream");
        }
    }

    public static final class GoogleDrive extends EndpointDeserializers.From {
        public GoogleDrive() {
            super("google-drive");
        }
    }

    public static final class GoogleMail extends EndpointDeserializers.From {
        public GoogleMail() {
            super("google-mail");
        }
    }

    public static final class GoogleMailStream extends EndpointDeserializers.From {
        public GoogleMailStream() {
            super("google-mail-stream");
        }
    }

    public static final class GooglePubsub extends EndpointDeserializers.From {
        public GooglePubsub() {
            super("google-pubsub");
        }
    }

    public static final class GoogleSheets extends EndpointDeserializers.From {
        public GoogleSheets() {
            super("google-sheets");
        }
    }

    public static final class GoogleSheetsStream extends EndpointDeserializers.From {
        public GoogleSheetsStream() {
            super("google-sheets-stream");
        }
    }

    public static final class GoogleStorage extends EndpointDeserializers.From {
        public GoogleStorage() {
            super("google-storage");
        }
    }

    public static final class Gora extends EndpointDeserializers.From {
        public Gora() {
            super("gora");
        }
    }

    public static final class Grpc extends EndpointDeserializers.From {
        public Grpc() {
            super("grpc");
        }
    }

    public static final class GuavaEventbus extends EndpointDeserializers.From {
        public GuavaEventbus() {
            super("guava-eventbus");
        }
    }

    public static final class HazelcastInstance extends EndpointDeserializers.From {
        public HazelcastInstance() {
            super("hazelcast-instance");
        }
    }

    public static final class HazelcastList extends EndpointDeserializers.From {
        public HazelcastList() {
            super("hazelcast-list");
        }
    }

    public static final class HazelcastMap extends EndpointDeserializers.From {
        public HazelcastMap() {
            super("hazelcast-map");
        }
    }

    public static final class HazelcastMultimap extends EndpointDeserializers.From {
        public HazelcastMultimap() {
            super("hazelcast-multimap");
        }
    }

    public static final class HazelcastQueue extends EndpointDeserializers.From {
        public HazelcastQueue() {
            super("hazelcast-queue");
        }
    }

    public static final class HazelcastReplicatedmap extends EndpointDeserializers.From {
        public HazelcastReplicatedmap() {
            super("hazelcast-replicatedmap");
        }
    }

    public static final class HazelcastSeda extends EndpointDeserializers.From {
        public HazelcastSeda() {
            super("hazelcast-seda");
        }
    }

    public static final class HazelcastSet extends EndpointDeserializers.From {
        public HazelcastSet() {
            super("hazelcast-set");
        }
    }

    public static final class HazelcastTopic extends EndpointDeserializers.From {
        public HazelcastTopic() {
            super("hazelcast-topic");
        }
    }

    public static final class Hbase extends EndpointDeserializers.From {
        public Hbase() {
            super("hbase");
        }
    }

    public static final class Hdfs extends EndpointDeserializers.From {
        public Hdfs() {
            super("hdfs");
        }
    }

    public static final class Iec60870Client extends EndpointDeserializers.From {
        public Iec60870Client() {
            super("iec60870-client");
        }
    }

    public static final class Iec60870Server extends EndpointDeserializers.From {
        public Iec60870Server() {
            super("iec60870-server");
        }
    }

    public static final class IgniteCache extends EndpointDeserializers.From {
        public IgniteCache() {
            super("ignite-cache");
        }
    }

    public static final class IgniteEvents extends EndpointDeserializers.From {
        public IgniteEvents() {
            super("ignite-events");
        }
    }

    public static final class IgniteMessaging extends EndpointDeserializers.From {
        public IgniteMessaging() {
            super("ignite-messaging");
        }
    }

    public static final class Imap extends EndpointDeserializers.From {
        public Imap() {
            super("imap");
        }
    }

    public static final class Imaps extends EndpointDeserializers.From {
        public Imaps() {
            super("imaps");
        }
    }

    public static final class Infinispan extends EndpointDeserializers.From {
        public Infinispan() {
            super("infinispan");
        }
    }

    public static final class InfinispanEmbedded extends EndpointDeserializers.From {
        public InfinispanEmbedded() {
            super("infinispan-embedded");
        }
    }

    public static final class Irc extends EndpointDeserializers.From {
        public Irc() {
            super("irc");
        }
    }

    public static final class Ironmq extends EndpointDeserializers.From {
        public Ironmq() {
            super("ironmq");
        }
    }

    public static final class Jbpm extends EndpointDeserializers.From {
        public Jbpm() {
            super("jbpm");
        }
    }

    public static final class Jcache extends EndpointDeserializers.From {
        public Jcache() {
            super("jcache");
        }
    }

    public static final class Jclouds extends EndpointDeserializers.From {
        public Jclouds() {
            super("jclouds");
        }
    }

    public static final class Jcr extends EndpointDeserializers.From {
        public Jcr() {
            super("jcr");
        }
    }

    public static final class Jetty extends EndpointDeserializers.From {
        public Jetty() {
            super("jetty");
        }
    }

    public static final class Jgroups extends EndpointDeserializers.From {
        public Jgroups() {
            super("jgroups");
        }
    }

    public static final class JgroupsRaft extends EndpointDeserializers.From {
        public JgroupsRaft() {
            super("jgroups-raft");
        }
    }

    public static final class Jira extends EndpointDeserializers.From {
        public Jira() {
            super("jira");
        }
    }

    public static final class Jms extends EndpointDeserializers.From {
        public Jms() {
            super("jms");
        }
    }

    public static final class Jmx extends EndpointDeserializers.From {
        public Jmx() {
            super("jmx");
        }
    }

    public static final class Jooq extends EndpointDeserializers.From {
        public Jooq() {
            super("jooq");
        }
    }

    public static final class Jpa extends EndpointDeserializers.From {
        public Jpa() {
            super("jpa");
        }
    }

    public static final class Jt400 extends EndpointDeserializers.From {
        public Jt400() {
            super("jt400");
        }
    }

    public static final class Kafka extends EndpointDeserializers.From {
        public Kafka() {
            super("kafka");
        }
    }

    public static final class Kamelet extends EndpointDeserializers.From {
        public Kamelet() {
            super("kamelet");
        }
    }

    public static final class KubernetesCustomResources extends EndpointDeserializers.From {
        public KubernetesCustomResources() {
            super("kubernetes-custom-resources");
        }
    }

    public static final class KubernetesDeployments extends EndpointDeserializers.From {
        public KubernetesDeployments() {
            super("kubernetes-deployments");
        }
    }

    public static final class KubernetesHpa extends EndpointDeserializers.From {
        public KubernetesHpa() {
            super("kubernetes-hpa");
        }
    }

    public static final class KubernetesJob extends EndpointDeserializers.From {
        public KubernetesJob() {
            super("kubernetes-job");
        }
    }

    public static final class KubernetesNamespaces extends EndpointDeserializers.From {
        public KubernetesNamespaces() {
            super("kubernetes-namespaces");
        }
    }

    public static final class KubernetesNodes extends EndpointDeserializers.From {
        public KubernetesNodes() {
            super("kubernetes-nodes");
        }
    }

    public static final class KubernetesPods extends EndpointDeserializers.From {
        public KubernetesPods() {
            super("kubernetes-pods");
        }
    }

    public static final class KubernetesReplicationControllers extends EndpointDeserializers.From {
        public KubernetesReplicationControllers() {
            super("kubernetes-replication-controllers");
        }
    }

    public static final class KubernetesServices extends EndpointDeserializers.From {
        public KubernetesServices() {
            super("kubernetes-services");
        }
    }

    public static final class Lumberjack extends EndpointDeserializers.From {
        public Lumberjack() {
            super("lumberjack");
        }
    }

    public static final class Master extends EndpointDeserializers.From {
        public Master() {
            super("master");
        }
    }

    public static final class MiloClient extends EndpointDeserializers.From {
        public MiloClient() {
            super("milo-client");
        }
    }

    public static final class MiloServer extends EndpointDeserializers.From {
        public MiloServer() {
            super("milo-server");
        }
    }

    public static final class Mina extends EndpointDeserializers.From {
        public Mina() {
            super("mina");
        }
    }

    public static final class Minio extends EndpointDeserializers.From {
        public Minio() {
            super("minio");
        }
    }

    public static final class Mllp extends EndpointDeserializers.From {
        public Mllp() {
            super("mllp");
        }
    }

    public static final class Mongodb extends EndpointDeserializers.From {
        public Mongodb() {
            super("mongodb");
        }
    }

    public static final class MongodbGridfs extends EndpointDeserializers.From {
        public MongodbGridfs() {
            super("mongodb-gridfs");
        }
    }

    public static final class Mybatis extends EndpointDeserializers.From {
        public Mybatis() {
            super("mybatis");
        }
    }

    public static final class Nats extends EndpointDeserializers.From {
        public Nats() {
            super("nats");
        }
    }

    public static final class Netty extends EndpointDeserializers.From {
        public Netty() {
            super("netty");
        }
    }

    public static final class NettyHttp extends EndpointDeserializers.From {
        public NettyHttp() {
            super("netty-http");
        }
    }

    public static final class Nitrite extends EndpointDeserializers.From {
        public Nitrite() {
            super("nitrite");
        }
    }

    public static final class Nsq extends EndpointDeserializers.From {
        public Nsq() {
            super("nsq");
        }
    }

    public static final class Oaipmh extends EndpointDeserializers.From {
        public Oaipmh() {
            super("oaipmh");
        }
    }

    public static final class Olingo2 extends EndpointDeserializers.From {
        public Olingo2() {
            super("olingo2");
        }
    }

    public static final class Olingo4 extends EndpointDeserializers.From {
        public Olingo4() {
            super("olingo4");
        }
    }

    public static final class Optaplanner extends EndpointDeserializers.From {
        public Optaplanner() {
            super("optaplanner");
        }
    }

    public static final class Paho extends EndpointDeserializers.From {
        public Paho() {
            super("paho");
        }
    }

    public static final class PahoMqtt5 extends EndpointDeserializers.From {
        public PahoMqtt5() {
            super("paho-mqtt5");
        }
    }

    public static final class PgReplicationSlot extends EndpointDeserializers.From {
        public PgReplicationSlot() {
            super("pg-replication-slot");
        }
    }

    public static final class Pgevent extends EndpointDeserializers.From {
        public Pgevent() {
            super("pgevent");
        }
    }

    public static final class PlatformHttp extends EndpointDeserializers.From {
        public PlatformHttp() {
            super("platform-http");
        }
    }

    public static final class Pop3 extends EndpointDeserializers.From {
        public Pop3() {
            super("pop3");
        }
    }

    public static final class Pop3s extends EndpointDeserializers.From {
        public Pop3s() {
            super("pop3s");
        }
    }

    public static final class Pubnub extends EndpointDeserializers.From {
        public Pubnub() {
            super("pubnub");
        }
    }

    public static final class Pulsar extends EndpointDeserializers.From {
        public Pulsar() {
            super("pulsar");
        }
    }

    public static final class Quartz extends EndpointDeserializers.From {
        public Quartz() {
            super("quartz");
        }
    }

    public static final class Quickfix extends EndpointDeserializers.From {
        public Quickfix() {
            super("quickfix");
        }
    }

    public static final class Rabbitmq extends EndpointDeserializers.From {
        public Rabbitmq() {
            super("rabbitmq");
        }
    }

    public static final class ReactiveStreams extends EndpointDeserializers.From {
        public ReactiveStreams() {
            super("reactive-streams");
        }
    }

    public static final class Ref extends EndpointDeserializers.From {
        public Ref() {
            super("ref");
        }
    }

    public static final class Rest extends EndpointDeserializers.From {
        public Rest() {
            super("rest");
        }
    }

    public static final class RestApi extends EndpointDeserializers.From {
        public RestApi() {
            super("rest-api");
        }
    }

    public static final class Resteasy extends EndpointDeserializers.From {
        public Resteasy() {
            super("resteasy");
        }
    }

    public static final class Robotframework extends EndpointDeserializers.From {
        public Robotframework() {
            super("robotframework");
        }
    }

    public static final class Rss extends EndpointDeserializers.From {
        public Rss() {
            super("rss");
        }
    }

    public static final class Salesforce extends EndpointDeserializers.From {
        public Salesforce() {
            super("salesforce");
        }
    }

    public static final class Scheduler extends EndpointDeserializers.From {
        public Scheduler() {
            super("scheduler");
        }
    }

    public static final class Seda extends EndpointDeserializers.From {
        public Seda() {
            super("seda");
        }
    }

    public static final class Service extends EndpointDeserializers.From {
        public Service() {
            super("service");
        }
    }

    public static final class Servlet extends EndpointDeserializers.From {
        public Servlet() {
            super("servlet");
        }
    }

    public static final class Sftp extends EndpointDeserializers.From {
        public Sftp() {
            super("sftp");
        }
    }

    public static final class Sip extends EndpointDeserializers.From {
        public Sip() {
            super("sip");
        }
    }

    public static final class Sips extends EndpointDeserializers.From {
        public Sips() {
            super("sips");
        }
    }

    public static final class Sjms extends EndpointDeserializers.From {
        public Sjms() {
            super("sjms");
        }
    }

    public static final class Sjms2 extends EndpointDeserializers.From {
        public Sjms2() {
            super("sjms2");
        }
    }

    public static final class Slack extends EndpointDeserializers.From {
        public Slack() {
            super("slack");
        }
    }

    public static final class Smpp extends EndpointDeserializers.From {
        public Smpp() {
            super("smpp");
        }
    }

    public static final class Smpps extends EndpointDeserializers.From {
        public Smpps() {
            super("smpps");
        }
    }

    public static final class Smtp extends EndpointDeserializers.From {
        public Smtp() {
            super("smtp");
        }
    }

    public static final class Smtps extends EndpointDeserializers.From {
        public Smtps() {
            super("smtps");
        }
    }

    public static final class Snmp extends EndpointDeserializers.From {
        public Snmp() {
            super("snmp");
        }
    }

    public static final class Soroush extends EndpointDeserializers.From {
        public Soroush() {
            super("soroush");
        }
    }

    public static final class Splunk extends EndpointDeserializers.From {
        public Splunk() {
            super("splunk");
        }
    }

    public static final class SpringEvent extends EndpointDeserializers.From {
        public SpringEvent() {
            super("spring-event");
        }
    }

    public static final class SpringIntegration extends EndpointDeserializers.From {
        public SpringIntegration() {
            super("spring-integration");
        }
    }

    public static final class SpringRabbitmq extends EndpointDeserializers.From {
        public SpringRabbitmq() {
            super("spring-rabbitmq");
        }
    }

    public static final class SpringRedis extends EndpointDeserializers.From {
        public SpringRedis() {
            super("spring-redis");
        }
    }

    public static final class SpringWs extends EndpointDeserializers.From {
        public SpringWs() {
            super("spring-ws");
        }
    }

    public static final class Sql extends EndpointDeserializers.From {
        public Sql() {
            super("sql");
        }
    }

    public static final class Ssh extends EndpointDeserializers.From {
        public Ssh() {
            super("ssh");
        }
    }

    public static final class Stomp extends EndpointDeserializers.From {
        public Stomp() {
            super("stomp");
        }
    }

    public static final class Stream extends EndpointDeserializers.From {
        public Stream() {
            super("stream");
        }
    }

    public static final class Stub extends EndpointDeserializers.From {
        public Stub() {
            super("stub");
        }
    }

    public static final class Telegram extends EndpointDeserializers.From {
        public Telegram() {
            super("telegram");
        }
    }

    public static final class Thrift extends EndpointDeserializers.From {
        public Thrift() {
            super("thrift");
        }
    }

    public static final class Timer extends EndpointDeserializers.From {
        public Timer() {
            super("timer");
        }
    }

    public static final class Twilio extends EndpointDeserializers.From {
        public Twilio() {
            super("twilio");
        }
    }

    public static final class TwitterDirectmessage extends EndpointDeserializers.From {
        public TwitterDirectmessage() {
            super("twitter-directmessage");
        }
    }

    public static final class TwitterSearch extends EndpointDeserializers.From {
        public TwitterSearch() {
            super("twitter-search");
        }
    }

    public static final class TwitterTimeline extends EndpointDeserializers.From {
        public TwitterTimeline() {
            super("twitter-timeline");
        }
    }

    public static final class Undertow extends EndpointDeserializers.From {
        public Undertow() {
            super("undertow");
        }
    }

    public static final class Vertx extends EndpointDeserializers.From {
        public Vertx() {
            super("vertx");
        }
    }

    public static final class VertxKafka extends EndpointDeserializers.From {
        public VertxKafka() {
            super("vertx-kafka");
        }
    }

    public static final class VertxWebsocket extends EndpointDeserializers.From {
        public VertxWebsocket() {
            super("vertx-websocket");
        }
    }

    public static final class Vm extends EndpointDeserializers.From {
        public Vm() {
            super("vm");
        }
    }

    public static final class Weather extends EndpointDeserializers.From {
        public Weather() {
            super("weather");
        }
    }

    public static final class Web3j extends EndpointDeserializers.From {
        public Web3j() {
            super("web3j");
        }
    }

    public static final class Webhook extends EndpointDeserializers.From {
        public Webhook() {
            super("webhook");
        }
    }

    public static final class Websocket extends EndpointDeserializers.From {
        public Websocket() {
            super("websocket");
        }
    }

    public static final class WebsocketJsr356 extends EndpointDeserializers.From {
        public WebsocketJsr356() {
            super("websocket-jsr356");
        }
    }

    public static final class Wordpress extends EndpointDeserializers.From {
        public Wordpress() {
            super("wordpress");
        }
    }

    public static final class Xmpp extends EndpointDeserializers.From {
        public Xmpp() {
            super("xmpp");
        }
    }

    public static final class Xquery extends EndpointDeserializers.From {
        public Xquery() {
            super("xquery");
        }
    }

    public static final class Yammer extends EndpointDeserializers.From {
        public Yammer() {
            super("yammer");
        }
    }

    public static final class Zendesk extends EndpointDeserializers.From {
        public Zendesk() {
            super("zendesk");
        }
    }

    public static final class Zookeeper extends EndpointDeserializers.From {
        public Zookeeper() {
            super("zookeeper");
        }
    }

    public static final class ZookeeperMaster extends EndpointDeserializers.From {
        public ZookeeperMaster() {
            super("zookeeper-master");
        }
    }
}
