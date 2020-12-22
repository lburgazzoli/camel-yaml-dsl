package com.github.lburgazzoli.camel.dsl.yaml.common.deserializers;

import com.github.lburgazzoli.camel.dsl.yaml.common.YamlDeserializerResolver;
import java.lang.Override;
import java.lang.String;
import org.snakeyaml.engine.v2.api.ConstructNode;

public final class EndpointConsumerDeserializersResolver implements YamlDeserializerResolver {
    @Override
    public int getOrder() {
        return YamlDeserializerResolver.ORDER_LOWEST;
    }

    @Override
    public ConstructNode resolve(String id) {
        switch(id) {
            case "activemq": return new EndpointConsumerDeserializers.Activemq();
            case "ahc-ws": return new EndpointConsumerDeserializers.AhcWs();
            case "ahc-wss": return new EndpointConsumerDeserializers.AhcWss();
            case "amqp": return new EndpointConsumerDeserializers.Amqp();
            case "apns": return new EndpointConsumerDeserializers.Apns();
            case "as2": return new EndpointConsumerDeserializers.As2();
            case "asterisk": return new EndpointConsumerDeserializers.Asterisk();
            case "atmos": return new EndpointConsumerDeserializers.Atmos();
            case "atmosphere-websocket": return new EndpointConsumerDeserializers.AtmosphereWebsocket();
            case "atom": return new EndpointConsumerDeserializers.Atom();
            case "atomix-map": return new EndpointConsumerDeserializers.AtomixMap();
            case "atomix-messaging": return new EndpointConsumerDeserializers.AtomixMessaging();
            case "atomix-queue": return new EndpointConsumerDeserializers.AtomixQueue();
            case "atomix-set": return new EndpointConsumerDeserializers.AtomixSet();
            case "atomix-value": return new EndpointConsumerDeserializers.AtomixValue();
            case "avro": return new EndpointConsumerDeserializers.Avro();
            case "aws-ddbstream": return new EndpointConsumerDeserializers.AwsDdbstream();
            case "aws-s3": return new EndpointConsumerDeserializers.AwsS3();
            case "aws-swf": return new EndpointConsumerDeserializers.AwsSwf();
            case "aws2-ddbstream": return new EndpointConsumerDeserializers.Aws2Ddbstream();
            case "aws2-kinesis": return new EndpointConsumerDeserializers.Aws2Kinesis();
            case "aws2-s3": return new EndpointConsumerDeserializers.Aws2S3();
            case "aws2-sqs": return new EndpointConsumerDeserializers.Aws2Sqs();
            case "azure-blob": return new EndpointConsumerDeserializers.AzureBlob();
            case "azure-eventhubs": return new EndpointConsumerDeserializers.AzureEventhubs();
            case "azure-queue": return new EndpointConsumerDeserializers.AzureQueue();
            case "azure-storage-blob": return new EndpointConsumerDeserializers.AzureStorageBlob();
            case "azure-storage-datalake": return new EndpointConsumerDeserializers.AzureStorageDatalake();
            case "azure-storage-queue": return new EndpointConsumerDeserializers.AzureStorageQueue();
            case "beanstalk": return new EndpointConsumerDeserializers.Beanstalk();
            case "box": return new EndpointConsumerDeserializers.Box();
            case "browse": return new EndpointConsumerDeserializers.Browse();
            case "cmis": return new EndpointConsumerDeserializers.Cmis();
            case "coap": return new EndpointConsumerDeserializers.Coap();
            case "coap+tcp": return new EndpointConsumerDeserializers.CoapTcp();
            case "coaps": return new EndpointConsumerDeserializers.Coaps();
            case "coaps+tcp": return new EndpointConsumerDeserializers.CoapsTcp();
            case "cometd": return new EndpointConsumerDeserializers.Cometd();
            case "cometds": return new EndpointConsumerDeserializers.Cometds();
            case "consul": return new EndpointConsumerDeserializers.Consul();
            case "corda": return new EndpointConsumerDeserializers.Corda();
            case "couchbase": return new EndpointConsumerDeserializers.Couchbase();
            case "couchdb": return new EndpointConsumerDeserializers.Couchdb();
            case "cql": return new EndpointConsumerDeserializers.Cql();
            case "cron": return new EndpointConsumerDeserializers.Cron();
            case "cxf": return new EndpointConsumerDeserializers.Cxf();
            case "cxfrs": return new EndpointConsumerDeserializers.Cxfrs();
            case "dataset": return new EndpointConsumerDeserializers.Dataset();
            case "debezium-mongodb": return new EndpointConsumerDeserializers.DebeziumMongodb();
            case "debezium-mysql": return new EndpointConsumerDeserializers.DebeziumMysql();
            case "debezium-postgres": return new EndpointConsumerDeserializers.DebeziumPostgres();
            case "debezium-sqlserver": return new EndpointConsumerDeserializers.DebeziumSqlserver();
            case "direct": return new EndpointConsumerDeserializers.Direct();
            case "direct-vm": return new EndpointConsumerDeserializers.DirectVm();
            case "disruptor": return new EndpointConsumerDeserializers.Disruptor();
            case "disruptor-vm": return new EndpointConsumerDeserializers.DisruptorVm();
            case "docker": return new EndpointConsumerDeserializers.Docker();
            case "dropbox": return new EndpointConsumerDeserializers.Dropbox();
            case "ehcache": return new EndpointConsumerDeserializers.Ehcache();
            case "elsql": return new EndpointConsumerDeserializers.Elsql();
            case "etcd-stats": return new EndpointConsumerDeserializers.EtcdStats();
            case "etcd-watch": return new EndpointConsumerDeserializers.EtcdWatch();
            case "facebook": return new EndpointConsumerDeserializers.Facebook();
            case "fhir": return new EndpointConsumerDeserializers.Fhir();
            case "file": return new EndpointConsumerDeserializers.File();
            case "file-watch": return new EndpointConsumerDeserializers.FileWatch();
            case "flatpack": return new EndpointConsumerDeserializers.Flatpack();
            case "ftp": return new EndpointConsumerDeserializers.Ftp();
            case "ftps": return new EndpointConsumerDeserializers.Ftps();
            case "git": return new EndpointConsumerDeserializers.Git();
            case "github": return new EndpointConsumerDeserializers.Github();
            case "google-calendar": return new EndpointConsumerDeserializers.GoogleCalendar();
            case "google-calendar-stream": return new EndpointConsumerDeserializers.GoogleCalendarStream();
            case "google-drive": return new EndpointConsumerDeserializers.GoogleDrive();
            case "google-mail": return new EndpointConsumerDeserializers.GoogleMail();
            case "google-mail-stream": return new EndpointConsumerDeserializers.GoogleMailStream();
            case "google-pubsub": return new EndpointConsumerDeserializers.GooglePubsub();
            case "google-sheets": return new EndpointConsumerDeserializers.GoogleSheets();
            case "google-sheets-stream": return new EndpointConsumerDeserializers.GoogleSheetsStream();
            case "google-storage": return new EndpointConsumerDeserializers.GoogleStorage();
            case "gora": return new EndpointConsumerDeserializers.Gora();
            case "grpc": return new EndpointConsumerDeserializers.Grpc();
            case "guava-eventbus": return new EndpointConsumerDeserializers.GuavaEventbus();
            case "hazelcast-instance": return new EndpointConsumerDeserializers.HazelcastInstance();
            case "hazelcast-list": return new EndpointConsumerDeserializers.HazelcastList();
            case "hazelcast-map": return new EndpointConsumerDeserializers.HazelcastMap();
            case "hazelcast-multimap": return new EndpointConsumerDeserializers.HazelcastMultimap();
            case "hazelcast-queue": return new EndpointConsumerDeserializers.HazelcastQueue();
            case "hazelcast-replicatedmap": return new EndpointConsumerDeserializers.HazelcastReplicatedmap();
            case "hazelcast-seda": return new EndpointConsumerDeserializers.HazelcastSeda();
            case "hazelcast-set": return new EndpointConsumerDeserializers.HazelcastSet();
            case "hazelcast-topic": return new EndpointConsumerDeserializers.HazelcastTopic();
            case "hbase": return new EndpointConsumerDeserializers.Hbase();
            case "hdfs": return new EndpointConsumerDeserializers.Hdfs();
            case "iec60870-client": return new EndpointConsumerDeserializers.Iec60870Client();
            case "iec60870-server": return new EndpointConsumerDeserializers.Iec60870Server();
            case "ignite-cache": return new EndpointConsumerDeserializers.IgniteCache();
            case "ignite-events": return new EndpointConsumerDeserializers.IgniteEvents();
            case "ignite-messaging": return new EndpointConsumerDeserializers.IgniteMessaging();
            case "imap": return new EndpointConsumerDeserializers.Imap();
            case "imaps": return new EndpointConsumerDeserializers.Imaps();
            case "infinispan": return new EndpointConsumerDeserializers.Infinispan();
            case "infinispan-embedded": return new EndpointConsumerDeserializers.InfinispanEmbedded();
            case "irc": return new EndpointConsumerDeserializers.Irc();
            case "ironmq": return new EndpointConsumerDeserializers.Ironmq();
            case "jbpm": return new EndpointConsumerDeserializers.Jbpm();
            case "jcache": return new EndpointConsumerDeserializers.Jcache();
            case "jclouds": return new EndpointConsumerDeserializers.Jclouds();
            case "jcr": return new EndpointConsumerDeserializers.Jcr();
            case "jetty": return new EndpointConsumerDeserializers.Jetty();
            case "jgroups": return new EndpointConsumerDeserializers.Jgroups();
            case "jgroups-raft": return new EndpointConsumerDeserializers.JgroupsRaft();
            case "jira": return new EndpointConsumerDeserializers.Jira();
            case "jms": return new EndpointConsumerDeserializers.Jms();
            case "jmx": return new EndpointConsumerDeserializers.Jmx();
            case "jooq": return new EndpointConsumerDeserializers.Jooq();
            case "jpa": return new EndpointConsumerDeserializers.Jpa();
            case "jt400": return new EndpointConsumerDeserializers.Jt400();
            case "kafka": return new EndpointConsumerDeserializers.Kafka();
            case "kamelet": return new EndpointConsumerDeserializers.Kamelet();
            case "kubernetes-custom-resources": return new EndpointConsumerDeserializers.KubernetesCustomResources();
            case "kubernetes-deployments": return new EndpointConsumerDeserializers.KubernetesDeployments();
            case "kubernetes-hpa": return new EndpointConsumerDeserializers.KubernetesHpa();
            case "kubernetes-job": return new EndpointConsumerDeserializers.KubernetesJob();
            case "kubernetes-namespaces": return new EndpointConsumerDeserializers.KubernetesNamespaces();
            case "kubernetes-nodes": return new EndpointConsumerDeserializers.KubernetesNodes();
            case "kubernetes-pods": return new EndpointConsumerDeserializers.KubernetesPods();
            case "kubernetes-replication-controllers": return new EndpointConsumerDeserializers.KubernetesReplicationControllers();
            case "kubernetes-services": return new EndpointConsumerDeserializers.KubernetesServices();
            case "lumberjack": return new EndpointConsumerDeserializers.Lumberjack();
            case "master": return new EndpointConsumerDeserializers.Master();
            case "milo-client": return new EndpointConsumerDeserializers.MiloClient();
            case "milo-server": return new EndpointConsumerDeserializers.MiloServer();
            case "mina": return new EndpointConsumerDeserializers.Mina();
            case "minio": return new EndpointConsumerDeserializers.Minio();
            case "mllp": return new EndpointConsumerDeserializers.Mllp();
            case "mongodb": return new EndpointConsumerDeserializers.Mongodb();
            case "mongodb-gridfs": return new EndpointConsumerDeserializers.MongodbGridfs();
            case "mybatis": return new EndpointConsumerDeserializers.Mybatis();
            case "nats": return new EndpointConsumerDeserializers.Nats();
            case "netty": return new EndpointConsumerDeserializers.Netty();
            case "netty-http": return new EndpointConsumerDeserializers.NettyHttp();
            case "nitrite": return new EndpointConsumerDeserializers.Nitrite();
            case "nsq": return new EndpointConsumerDeserializers.Nsq();
            case "oaipmh": return new EndpointConsumerDeserializers.Oaipmh();
            case "olingo2": return new EndpointConsumerDeserializers.Olingo2();
            case "olingo4": return new EndpointConsumerDeserializers.Olingo4();
            case "optaplanner": return new EndpointConsumerDeserializers.Optaplanner();
            case "paho": return new EndpointConsumerDeserializers.Paho();
            case "paho-mqtt5": return new EndpointConsumerDeserializers.PahoMqtt5();
            case "pg-replication-slot": return new EndpointConsumerDeserializers.PgReplicationSlot();
            case "pgevent": return new EndpointConsumerDeserializers.Pgevent();
            case "platform-http": return new EndpointConsumerDeserializers.PlatformHttp();
            case "pop3": return new EndpointConsumerDeserializers.Pop3();
            case "pop3s": return new EndpointConsumerDeserializers.Pop3s();
            case "pubnub": return new EndpointConsumerDeserializers.Pubnub();
            case "pulsar": return new EndpointConsumerDeserializers.Pulsar();
            case "quartz": return new EndpointConsumerDeserializers.Quartz();
            case "quickfix": return new EndpointConsumerDeserializers.Quickfix();
            case "rabbitmq": return new EndpointConsumerDeserializers.Rabbitmq();
            case "reactive-streams": return new EndpointConsumerDeserializers.ReactiveStreams();
            case "ref": return new EndpointConsumerDeserializers.Ref();
            case "rest": return new EndpointConsumerDeserializers.Rest();
            case "rest-api": return new EndpointConsumerDeserializers.RestApi();
            case "resteasy": return new EndpointConsumerDeserializers.Resteasy();
            case "robotframework": return new EndpointConsumerDeserializers.Robotframework();
            case "rss": return new EndpointConsumerDeserializers.Rss();
            case "salesforce": return new EndpointConsumerDeserializers.Salesforce();
            case "scheduler": return new EndpointConsumerDeserializers.Scheduler();
            case "seda": return new EndpointConsumerDeserializers.Seda();
            case "service": return new EndpointConsumerDeserializers.Service();
            case "servlet": return new EndpointConsumerDeserializers.Servlet();
            case "sftp": return new EndpointConsumerDeserializers.Sftp();
            case "sip": return new EndpointConsumerDeserializers.Sip();
            case "sips": return new EndpointConsumerDeserializers.Sips();
            case "sjms": return new EndpointConsumerDeserializers.Sjms();
            case "sjms2": return new EndpointConsumerDeserializers.Sjms2();
            case "slack": return new EndpointConsumerDeserializers.Slack();
            case "smpp": return new EndpointConsumerDeserializers.Smpp();
            case "smpps": return new EndpointConsumerDeserializers.Smpps();
            case "smtp": return new EndpointConsumerDeserializers.Smtp();
            case "smtps": return new EndpointConsumerDeserializers.Smtps();
            case "snmp": return new EndpointConsumerDeserializers.Snmp();
            case "soroush": return new EndpointConsumerDeserializers.Soroush();
            case "splunk": return new EndpointConsumerDeserializers.Splunk();
            case "spring-event": return new EndpointConsumerDeserializers.SpringEvent();
            case "spring-integration": return new EndpointConsumerDeserializers.SpringIntegration();
            case "spring-rabbitmq": return new EndpointConsumerDeserializers.SpringRabbitmq();
            case "spring-redis": return new EndpointConsumerDeserializers.SpringRedis();
            case "spring-ws": return new EndpointConsumerDeserializers.SpringWs();
            case "sql": return new EndpointConsumerDeserializers.Sql();
            case "ssh": return new EndpointConsumerDeserializers.Ssh();
            case "stomp": return new EndpointConsumerDeserializers.Stomp();
            case "stream": return new EndpointConsumerDeserializers.Stream();
            case "stub": return new EndpointConsumerDeserializers.Stub();
            case "telegram": return new EndpointConsumerDeserializers.Telegram();
            case "thrift": return new EndpointConsumerDeserializers.Thrift();
            case "timer": return new EndpointConsumerDeserializers.Timer();
            case "twilio": return new EndpointConsumerDeserializers.Twilio();
            case "twitter-directmessage": return new EndpointConsumerDeserializers.TwitterDirectmessage();
            case "twitter-search": return new EndpointConsumerDeserializers.TwitterSearch();
            case "twitter-timeline": return new EndpointConsumerDeserializers.TwitterTimeline();
            case "undertow": return new EndpointConsumerDeserializers.Undertow();
            case "vertx": return new EndpointConsumerDeserializers.Vertx();
            case "vertx-kafka": return new EndpointConsumerDeserializers.VertxKafka();
            case "vertx-websocket": return new EndpointConsumerDeserializers.VertxWebsocket();
            case "vm": return new EndpointConsumerDeserializers.Vm();
            case "weather": return new EndpointConsumerDeserializers.Weather();
            case "web3j": return new EndpointConsumerDeserializers.Web3j();
            case "webhook": return new EndpointConsumerDeserializers.Webhook();
            case "websocket": return new EndpointConsumerDeserializers.Websocket();
            case "websocket-jsr356": return new EndpointConsumerDeserializers.WebsocketJsr356();
            case "wordpress": return new EndpointConsumerDeserializers.Wordpress();
            case "xmpp": return new EndpointConsumerDeserializers.Xmpp();
            case "xquery": return new EndpointConsumerDeserializers.Xquery();
            case "yammer": return new EndpointConsumerDeserializers.Yammer();
            case "zendesk": return new EndpointConsumerDeserializers.Zendesk();
            case "zookeeper": return new EndpointConsumerDeserializers.Zookeeper();
            case "zookeeper-master": return new EndpointConsumerDeserializers.ZookeeperMaster();
        }
        return null;
    }
}
