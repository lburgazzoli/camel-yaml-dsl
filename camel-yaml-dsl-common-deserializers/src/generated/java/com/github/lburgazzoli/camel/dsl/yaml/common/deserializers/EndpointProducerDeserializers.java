package com.github.lburgazzoli.camel.dsl.yaml.common.deserializers;

import com.github.lburgazzoli.camel.dsl.yaml.annotations.YamlType;
import com.github.lburgazzoli.camel.dsl.yaml.common.YamlDeserializerSupport;

public final class EndpointProducerDeserializers extends YamlDeserializerSupport {
    private EndpointProducerDeserializers() {
    }

    @YamlType(
            nodes = "activemq"
    )
    public static final class Activemq extends EndpointDeserializers.To {
        public Activemq() {
            super("activemq");
        }
    }

    @YamlType(
            nodes = "ahc"
    )
    public static final class Ahc extends EndpointDeserializers.To {
        public Ahc() {
            super("ahc");
        }
    }

    @YamlType(
            nodes = "ahc-ws"
    )
    public static final class AhcWs extends EndpointDeserializers.To {
        public AhcWs() {
            super("ahc-ws");
        }
    }

    @YamlType(
            nodes = "ahc-wss"
    )
    public static final class AhcWss extends EndpointDeserializers.To {
        public AhcWss() {
            super("ahc-wss");
        }
    }

    @YamlType(
            nodes = "amqp"
    )
    public static final class Amqp extends EndpointDeserializers.To {
        public Amqp() {
            super("amqp");
        }
    }

    @YamlType(
            nodes = "apns"
    )
    public static final class Apns extends EndpointDeserializers.To {
        public Apns() {
            super("apns");
        }
    }

    @YamlType(
            nodes = "arangodb"
    )
    public static final class Arangodb extends EndpointDeserializers.To {
        public Arangodb() {
            super("arangodb");
        }
    }

    @YamlType(
            nodes = "as2"
    )
    public static final class As2 extends EndpointDeserializers.To {
        public As2() {
            super("as2");
        }
    }

    @YamlType(
            nodes = "asterisk"
    )
    public static final class Asterisk extends EndpointDeserializers.To {
        public Asterisk() {
            super("asterisk");
        }
    }

    @YamlType(
            nodes = "atlasmap"
    )
    public static final class Atlasmap extends EndpointDeserializers.To {
        public Atlasmap() {
            super("atlasmap");
        }
    }

    @YamlType(
            nodes = "atmos"
    )
    public static final class Atmos extends EndpointDeserializers.To {
        public Atmos() {
            super("atmos");
        }
    }

    @YamlType(
            nodes = "atmosphere-websocket"
    )
    public static final class AtmosphereWebsocket extends EndpointDeserializers.To {
        public AtmosphereWebsocket() {
            super("atmosphere-websocket");
        }
    }

    @YamlType(
            nodes = "atomix-map"
    )
    public static final class AtomixMap extends EndpointDeserializers.To {
        public AtomixMap() {
            super("atomix-map");
        }
    }

    @YamlType(
            nodes = "atomix-messaging"
    )
    public static final class AtomixMessaging extends EndpointDeserializers.To {
        public AtomixMessaging() {
            super("atomix-messaging");
        }
    }

    @YamlType(
            nodes = "atomix-multimap"
    )
    public static final class AtomixMultimap extends EndpointDeserializers.To {
        public AtomixMultimap() {
            super("atomix-multimap");
        }
    }

    @YamlType(
            nodes = "atomix-queue"
    )
    public static final class AtomixQueue extends EndpointDeserializers.To {
        public AtomixQueue() {
            super("atomix-queue");
        }
    }

    @YamlType(
            nodes = "atomix-set"
    )
    public static final class AtomixSet extends EndpointDeserializers.To {
        public AtomixSet() {
            super("atomix-set");
        }
    }

    @YamlType(
            nodes = "atomix-value"
    )
    public static final class AtomixValue extends EndpointDeserializers.To {
        public AtomixValue() {
            super("atomix-value");
        }
    }

    @YamlType(
            nodes = "avro"
    )
    public static final class Avro extends EndpointDeserializers.To {
        public Avro() {
            super("avro");
        }
    }

    @YamlType(
            nodes = "aws-cw"
    )
    public static final class AwsCw extends EndpointDeserializers.To {
        public AwsCw() {
            super("aws-cw");
        }
    }

    @YamlType(
            nodes = "aws-ddb"
    )
    public static final class AwsDdb extends EndpointDeserializers.To {
        public AwsDdb() {
            super("aws-ddb");
        }
    }

    @YamlType(
            nodes = "aws-ec2"
    )
    public static final class AwsEc2 extends EndpointDeserializers.To {
        public AwsEc2() {
            super("aws-ec2");
        }
    }

    @YamlType(
            nodes = "aws-ecs"
    )
    public static final class AwsEcs extends EndpointDeserializers.To {
        public AwsEcs() {
            super("aws-ecs");
        }
    }

    @YamlType(
            nodes = "aws-eks"
    )
    public static final class AwsEks extends EndpointDeserializers.To {
        public AwsEks() {
            super("aws-eks");
        }
    }

    @YamlType(
            nodes = "aws-iam"
    )
    public static final class AwsIam extends EndpointDeserializers.To {
        public AwsIam() {
            super("aws-iam");
        }
    }

    @YamlType(
            nodes = "aws-s3"
    )
    public static final class AwsS3 extends EndpointDeserializers.To {
        public AwsS3() {
            super("aws-s3");
        }
    }

    @YamlType(
            nodes = "aws-swf"
    )
    public static final class AwsSwf extends EndpointDeserializers.To {
        public AwsSwf() {
            super("aws-swf");
        }
    }

    @YamlType(
            nodes = "aws2-athena"
    )
    public static final class Aws2Athena extends EndpointDeserializers.To {
        public Aws2Athena() {
            super("aws2-athena");
        }
    }

    @YamlType(
            nodes = "aws2-cw"
    )
    public static final class Aws2Cw extends EndpointDeserializers.To {
        public Aws2Cw() {
            super("aws2-cw");
        }
    }

    @YamlType(
            nodes = "aws2-ddb"
    )
    public static final class Aws2Ddb extends EndpointDeserializers.To {
        public Aws2Ddb() {
            super("aws2-ddb");
        }
    }

    @YamlType(
            nodes = "aws2-ec2"
    )
    public static final class Aws2Ec2 extends EndpointDeserializers.To {
        public Aws2Ec2() {
            super("aws2-ec2");
        }
    }

    @YamlType(
            nodes = "aws2-ecs"
    )
    public static final class Aws2Ecs extends EndpointDeserializers.To {
        public Aws2Ecs() {
            super("aws2-ecs");
        }
    }

    @YamlType(
            nodes = "aws2-eks"
    )
    public static final class Aws2Eks extends EndpointDeserializers.To {
        public Aws2Eks() {
            super("aws2-eks");
        }
    }

    @YamlType(
            nodes = "aws2-eventbridge"
    )
    public static final class Aws2Eventbridge extends EndpointDeserializers.To {
        public Aws2Eventbridge() {
            super("aws2-eventbridge");
        }
    }

    @YamlType(
            nodes = "aws2-iam"
    )
    public static final class Aws2Iam extends EndpointDeserializers.To {
        public Aws2Iam() {
            super("aws2-iam");
        }
    }

    @YamlType(
            nodes = "aws2-kinesis"
    )
    public static final class Aws2Kinesis extends EndpointDeserializers.To {
        public Aws2Kinesis() {
            super("aws2-kinesis");
        }
    }

    @YamlType(
            nodes = "aws2-kinesis-firehose"
    )
    public static final class Aws2KinesisFirehose extends EndpointDeserializers.To {
        public Aws2KinesisFirehose() {
            super("aws2-kinesis-firehose");
        }
    }

    @YamlType(
            nodes = "aws2-kms"
    )
    public static final class Aws2Kms extends EndpointDeserializers.To {
        public Aws2Kms() {
            super("aws2-kms");
        }
    }

    @YamlType(
            nodes = "aws2-lambda"
    )
    public static final class Aws2Lambda extends EndpointDeserializers.To {
        public Aws2Lambda() {
            super("aws2-lambda");
        }
    }

    @YamlType(
            nodes = "aws2-mq"
    )
    public static final class Aws2Mq extends EndpointDeserializers.To {
        public Aws2Mq() {
            super("aws2-mq");
        }
    }

    @YamlType(
            nodes = "aws2-msk"
    )
    public static final class Aws2Msk extends EndpointDeserializers.To {
        public Aws2Msk() {
            super("aws2-msk");
        }
    }

    @YamlType(
            nodes = "aws2-s3"
    )
    public static final class Aws2S3 extends EndpointDeserializers.To {
        public Aws2S3() {
            super("aws2-s3");
        }
    }

    @YamlType(
            nodes = "aws2-ses"
    )
    public static final class Aws2Ses extends EndpointDeserializers.To {
        public Aws2Ses() {
            super("aws2-ses");
        }
    }

    @YamlType(
            nodes = "aws2-sns"
    )
    public static final class Aws2Sns extends EndpointDeserializers.To {
        public Aws2Sns() {
            super("aws2-sns");
        }
    }

    @YamlType(
            nodes = "aws2-sqs"
    )
    public static final class Aws2Sqs extends EndpointDeserializers.To {
        public Aws2Sqs() {
            super("aws2-sqs");
        }
    }

    @YamlType(
            nodes = "aws2-sts"
    )
    public static final class Aws2Sts extends EndpointDeserializers.To {
        public Aws2Sts() {
            super("aws2-sts");
        }
    }

    @YamlType(
            nodes = "aws2-translate"
    )
    public static final class Aws2Translate extends EndpointDeserializers.To {
        public Aws2Translate() {
            super("aws2-translate");
        }
    }

    @YamlType(
            nodes = "azure-blob"
    )
    public static final class AzureBlob extends EndpointDeserializers.To {
        public AzureBlob() {
            super("azure-blob");
        }
    }

    @YamlType(
            nodes = "azure-eventhubs"
    )
    public static final class AzureEventhubs extends EndpointDeserializers.To {
        public AzureEventhubs() {
            super("azure-eventhubs");
        }
    }

    @YamlType(
            nodes = "azure-queue"
    )
    public static final class AzureQueue extends EndpointDeserializers.To {
        public AzureQueue() {
            super("azure-queue");
        }
    }

    @YamlType(
            nodes = "azure-storage-blob"
    )
    public static final class AzureStorageBlob extends EndpointDeserializers.To {
        public AzureStorageBlob() {
            super("azure-storage-blob");
        }
    }

    @YamlType(
            nodes = "azure-storage-datalake"
    )
    public static final class AzureStorageDatalake extends EndpointDeserializers.To {
        public AzureStorageDatalake() {
            super("azure-storage-datalake");
        }
    }

    @YamlType(
            nodes = "azure-storage-queue"
    )
    public static final class AzureStorageQueue extends EndpointDeserializers.To {
        public AzureStorageQueue() {
            super("azure-storage-queue");
        }
    }

    @YamlType(
            nodes = "bean"
    )
    public static final class Bean extends EndpointDeserializers.To {
        public Bean() {
            super("bean");
        }
    }

    @YamlType(
            nodes = "bean-validator"
    )
    public static final class BeanValidator extends EndpointDeserializers.To {
        public BeanValidator() {
            super("bean-validator");
        }
    }

    @YamlType(
            nodes = "beanstalk"
    )
    public static final class Beanstalk extends EndpointDeserializers.To {
        public Beanstalk() {
            super("beanstalk");
        }
    }

    @YamlType(
            nodes = "bonita"
    )
    public static final class Bonita extends EndpointDeserializers.To {
        public Bonita() {
            super("bonita");
        }
    }

    @YamlType(
            nodes = "box"
    )
    public static final class Box extends EndpointDeserializers.To {
        public Box() {
            super("box");
        }
    }

    @YamlType(
            nodes = "braintree"
    )
    public static final class Braintree extends EndpointDeserializers.To {
        public Braintree() {
            super("braintree");
        }
    }

    @YamlType(
            nodes = "browse"
    )
    public static final class Browse extends EndpointDeserializers.To {
        public Browse() {
            super("browse");
        }
    }

    @YamlType(
            nodes = "caffeine-cache"
    )
    public static final class CaffeineCache extends EndpointDeserializers.To {
        public CaffeineCache() {
            super("caffeine-cache");
        }
    }

    @YamlType(
            nodes = "caffeine-loadcache"
    )
    public static final class CaffeineLoadcache extends EndpointDeserializers.To {
        public CaffeineLoadcache() {
            super("caffeine-loadcache");
        }
    }

    @YamlType(
            nodes = "chatscript"
    )
    public static final class Chatscript extends EndpointDeserializers.To {
        public Chatscript() {
            super("chatscript");
        }
    }

    @YamlType(
            nodes = "chunk"
    )
    public static final class Chunk extends EndpointDeserializers.To {
        public Chunk() {
            super("chunk");
        }
    }

    @YamlType(
            nodes = "class"
    )
    public static final class Class extends EndpointDeserializers.To {
        public Class() {
            super("class");
        }
    }

    @YamlType(
            nodes = "cm-sms"
    )
    public static final class CmSms extends EndpointDeserializers.To {
        public CmSms() {
            super("cm-sms");
        }
    }

    @YamlType(
            nodes = "cmis"
    )
    public static final class Cmis extends EndpointDeserializers.To {
        public Cmis() {
            super("cmis");
        }
    }

    @YamlType(
            nodes = "coap"
    )
    public static final class Coap extends EndpointDeserializers.To {
        public Coap() {
            super("coap");
        }
    }

    @YamlType(
            nodes = "coap+tcp"
    )
    public static final class CoapTcp extends EndpointDeserializers.To {
        public CoapTcp() {
            super("coap+tcp");
        }
    }

    @YamlType(
            nodes = "coaps"
    )
    public static final class Coaps extends EndpointDeserializers.To {
        public Coaps() {
            super("coaps");
        }
    }

    @YamlType(
            nodes = "coaps+tcp"
    )
    public static final class CoapsTcp extends EndpointDeserializers.To {
        public CoapsTcp() {
            super("coaps+tcp");
        }
    }

    @YamlType(
            nodes = "cometd"
    )
    public static final class Cometd extends EndpointDeserializers.To {
        public Cometd() {
            super("cometd");
        }
    }

    @YamlType(
            nodes = "cometds"
    )
    public static final class Cometds extends EndpointDeserializers.To {
        public Cometds() {
            super("cometds");
        }
    }

    @YamlType(
            nodes = "consul"
    )
    public static final class Consul extends EndpointDeserializers.To {
        public Consul() {
            super("consul");
        }
    }

    @YamlType(
            nodes = "controlbus"
    )
    public static final class Controlbus extends EndpointDeserializers.To {
        public Controlbus() {
            super("controlbus");
        }
    }

    @YamlType(
            nodes = "corda"
    )
    public static final class Corda extends EndpointDeserializers.To {
        public Corda() {
            super("corda");
        }
    }

    @YamlType(
            nodes = "couchbase"
    )
    public static final class Couchbase extends EndpointDeserializers.To {
        public Couchbase() {
            super("couchbase");
        }
    }

    @YamlType(
            nodes = "couchdb"
    )
    public static final class Couchdb extends EndpointDeserializers.To {
        public Couchdb() {
            super("couchdb");
        }
    }

    @YamlType(
            nodes = "cql"
    )
    public static final class Cql extends EndpointDeserializers.To {
        public Cql() {
            super("cql");
        }
    }

    @YamlType(
            nodes = "crypto"
    )
    public static final class Crypto extends EndpointDeserializers.To {
        public Crypto() {
            super("crypto");
        }
    }

    @YamlType(
            nodes = "crypto-cms"
    )
    public static final class CryptoCms extends EndpointDeserializers.To {
        public CryptoCms() {
            super("crypto-cms");
        }
    }

    @YamlType(
            nodes = "cxf"
    )
    public static final class Cxf extends EndpointDeserializers.To {
        public Cxf() {
            super("cxf");
        }
    }

    @YamlType(
            nodes = "cxfrs"
    )
    public static final class Cxfrs extends EndpointDeserializers.To {
        public Cxfrs() {
            super("cxfrs");
        }
    }

    @YamlType(
            nodes = "dataformat"
    )
    public static final class Dataformat extends EndpointDeserializers.To {
        public Dataformat() {
            super("dataformat");
        }
    }

    @YamlType(
            nodes = "dataset"
    )
    public static final class Dataset extends EndpointDeserializers.To {
        public Dataset() {
            super("dataset");
        }
    }

    @YamlType(
            nodes = "dataset-test"
    )
    public static final class DatasetTest extends EndpointDeserializers.To {
        public DatasetTest() {
            super("dataset-test");
        }
    }

    @YamlType(
            nodes = "digitalocean"
    )
    public static final class Digitalocean extends EndpointDeserializers.To {
        public Digitalocean() {
            super("digitalocean");
        }
    }

    @YamlType(
            nodes = "direct"
    )
    public static final class Direct extends EndpointDeserializers.To {
        public Direct() {
            super("direct");
        }
    }

    @YamlType(
            nodes = "direct-vm"
    )
    public static final class DirectVm extends EndpointDeserializers.To {
        public DirectVm() {
            super("direct-vm");
        }
    }

    @YamlType(
            nodes = "disruptor"
    )
    public static final class Disruptor extends EndpointDeserializers.To {
        public Disruptor() {
            super("disruptor");
        }
    }

    @YamlType(
            nodes = "disruptor-vm"
    )
    public static final class DisruptorVm extends EndpointDeserializers.To {
        public DisruptorVm() {
            super("disruptor-vm");
        }
    }

    @YamlType(
            nodes = "djl"
    )
    public static final class Djl extends EndpointDeserializers.To {
        public Djl() {
            super("djl");
        }
    }

    @YamlType(
            nodes = "dns"
    )
    public static final class Dns extends EndpointDeserializers.To {
        public Dns() {
            super("dns");
        }
    }

    @YamlType(
            nodes = "docker"
    )
    public static final class Docker extends EndpointDeserializers.To {
        public Docker() {
            super("docker");
        }
    }

    @YamlType(
            nodes = "dozer"
    )
    public static final class Dozer extends EndpointDeserializers.To {
        public Dozer() {
            super("dozer");
        }
    }

    @YamlType(
            nodes = "drill"
    )
    public static final class Drill extends EndpointDeserializers.To {
        public Drill() {
            super("drill");
        }
    }

    @YamlType(
            nodes = "dropbox"
    )
    public static final class Dropbox extends EndpointDeserializers.To {
        public Dropbox() {
            super("dropbox");
        }
    }

    @YamlType(
            nodes = "ehcache"
    )
    public static final class Ehcache extends EndpointDeserializers.To {
        public Ehcache() {
            super("ehcache");
        }
    }

    @YamlType(
            nodes = "elasticsearch-rest"
    )
    public static final class ElasticsearchRest extends EndpointDeserializers.To {
        public ElasticsearchRest() {
            super("elasticsearch-rest");
        }
    }

    @YamlType(
            nodes = "elsql"
    )
    public static final class Elsql extends EndpointDeserializers.To {
        public Elsql() {
            super("elsql");
        }
    }

    @YamlType(
            nodes = "etcd-keys"
    )
    public static final class EtcdKeys extends EndpointDeserializers.To {
        public EtcdKeys() {
            super("etcd-keys");
        }
    }

    @YamlType(
            nodes = "etcd-stats"
    )
    public static final class EtcdStats extends EndpointDeserializers.To {
        public EtcdStats() {
            super("etcd-stats");
        }
    }

    @YamlType(
            nodes = "exec"
    )
    public static final class Exec extends EndpointDeserializers.To {
        public Exec() {
            super("exec");
        }
    }

    @YamlType(
            nodes = "facebook"
    )
    public static final class Facebook extends EndpointDeserializers.To {
        public Facebook() {
            super("facebook");
        }
    }

    @YamlType(
            nodes = "fhir"
    )
    public static final class Fhir extends EndpointDeserializers.To {
        public Fhir() {
            super("fhir");
        }
    }

    @YamlType(
            nodes = "file"
    )
    public static final class File extends EndpointDeserializers.To {
        public File() {
            super("file");
        }
    }

    @YamlType(
            nodes = "flatpack"
    )
    public static final class Flatpack extends EndpointDeserializers.To {
        public Flatpack() {
            super("flatpack");
        }
    }

    @YamlType(
            nodes = "flink"
    )
    public static final class Flink extends EndpointDeserializers.To {
        public Flink() {
            super("flink");
        }
    }

    @YamlType(
            nodes = "fop"
    )
    public static final class Fop extends EndpointDeserializers.To {
        public Fop() {
            super("fop");
        }
    }

    @YamlType(
            nodes = "freemarker"
    )
    public static final class Freemarker extends EndpointDeserializers.To {
        public Freemarker() {
            super("freemarker");
        }
    }

    @YamlType(
            nodes = "ftp"
    )
    public static final class Ftp extends EndpointDeserializers.To {
        public Ftp() {
            super("ftp");
        }
    }

    @YamlType(
            nodes = "ftps"
    )
    public static final class Ftps extends EndpointDeserializers.To {
        public Ftps() {
            super("ftps");
        }
    }

    @YamlType(
            nodes = "ganglia"
    )
    public static final class Ganglia extends EndpointDeserializers.To {
        public Ganglia() {
            super("ganglia");
        }
    }

    @YamlType(
            nodes = "geocoder"
    )
    public static final class Geocoder extends EndpointDeserializers.To {
        public Geocoder() {
            super("geocoder");
        }
    }

    @YamlType(
            nodes = "git"
    )
    public static final class Git extends EndpointDeserializers.To {
        public Git() {
            super("git");
        }
    }

    @YamlType(
            nodes = "github"
    )
    public static final class Github extends EndpointDeserializers.To {
        public Github() {
            super("github");
        }
    }

    @YamlType(
            nodes = "google-bigquery"
    )
    public static final class GoogleBigquery extends EndpointDeserializers.To {
        public GoogleBigquery() {
            super("google-bigquery");
        }
    }

    @YamlType(
            nodes = "google-bigquery-sql"
    )
    public static final class GoogleBigquerySql extends EndpointDeserializers.To {
        public GoogleBigquerySql() {
            super("google-bigquery-sql");
        }
    }

    @YamlType(
            nodes = "google-calendar"
    )
    public static final class GoogleCalendar extends EndpointDeserializers.To {
        public GoogleCalendar() {
            super("google-calendar");
        }
    }

    @YamlType(
            nodes = "google-drive"
    )
    public static final class GoogleDrive extends EndpointDeserializers.To {
        public GoogleDrive() {
            super("google-drive");
        }
    }

    @YamlType(
            nodes = "google-mail"
    )
    public static final class GoogleMail extends EndpointDeserializers.To {
        public GoogleMail() {
            super("google-mail");
        }
    }

    @YamlType(
            nodes = "google-pubsub"
    )
    public static final class GooglePubsub extends EndpointDeserializers.To {
        public GooglePubsub() {
            super("google-pubsub");
        }
    }

    @YamlType(
            nodes = "google-sheets"
    )
    public static final class GoogleSheets extends EndpointDeserializers.To {
        public GoogleSheets() {
            super("google-sheets");
        }
    }

    @YamlType(
            nodes = "google-storage"
    )
    public static final class GoogleStorage extends EndpointDeserializers.To {
        public GoogleStorage() {
            super("google-storage");
        }
    }

    @YamlType(
            nodes = "gora"
    )
    public static final class Gora extends EndpointDeserializers.To {
        public Gora() {
            super("gora");
        }
    }

    @YamlType(
            nodes = "grape"
    )
    public static final class Grape extends EndpointDeserializers.To {
        public Grape() {
            super("grape");
        }
    }

    @YamlType(
            nodes = "graphql"
    )
    public static final class Graphql extends EndpointDeserializers.To {
        public Graphql() {
            super("graphql");
        }
    }

    @YamlType(
            nodes = "grpc"
    )
    public static final class Grpc extends EndpointDeserializers.To {
        public Grpc() {
            super("grpc");
        }
    }

    @YamlType(
            nodes = "guava-eventbus"
    )
    public static final class GuavaEventbus extends EndpointDeserializers.To {
        public GuavaEventbus() {
            super("guava-eventbus");
        }
    }

    @YamlType(
            nodes = "hazelcast-atomicvalue"
    )
    public static final class HazelcastAtomicvalue extends EndpointDeserializers.To {
        public HazelcastAtomicvalue() {
            super("hazelcast-atomicvalue");
        }
    }

    @YamlType(
            nodes = "hazelcast-list"
    )
    public static final class HazelcastList extends EndpointDeserializers.To {
        public HazelcastList() {
            super("hazelcast-list");
        }
    }

    @YamlType(
            nodes = "hazelcast-map"
    )
    public static final class HazelcastMap extends EndpointDeserializers.To {
        public HazelcastMap() {
            super("hazelcast-map");
        }
    }

    @YamlType(
            nodes = "hazelcast-multimap"
    )
    public static final class HazelcastMultimap extends EndpointDeserializers.To {
        public HazelcastMultimap() {
            super("hazelcast-multimap");
        }
    }

    @YamlType(
            nodes = "hazelcast-queue"
    )
    public static final class HazelcastQueue extends EndpointDeserializers.To {
        public HazelcastQueue() {
            super("hazelcast-queue");
        }
    }

    @YamlType(
            nodes = "hazelcast-replicatedmap"
    )
    public static final class HazelcastReplicatedmap extends EndpointDeserializers.To {
        public HazelcastReplicatedmap() {
            super("hazelcast-replicatedmap");
        }
    }

    @YamlType(
            nodes = "hazelcast-ringbuffer"
    )
    public static final class HazelcastRingbuffer extends EndpointDeserializers.To {
        public HazelcastRingbuffer() {
            super("hazelcast-ringbuffer");
        }
    }

    @YamlType(
            nodes = "hazelcast-seda"
    )
    public static final class HazelcastSeda extends EndpointDeserializers.To {
        public HazelcastSeda() {
            super("hazelcast-seda");
        }
    }

    @YamlType(
            nodes = "hazelcast-set"
    )
    public static final class HazelcastSet extends EndpointDeserializers.To {
        public HazelcastSet() {
            super("hazelcast-set");
        }
    }

    @YamlType(
            nodes = "hazelcast-topic"
    )
    public static final class HazelcastTopic extends EndpointDeserializers.To {
        public HazelcastTopic() {
            super("hazelcast-topic");
        }
    }

    @YamlType(
            nodes = "hbase"
    )
    public static final class Hbase extends EndpointDeserializers.To {
        public Hbase() {
            super("hbase");
        }
    }

    @YamlType(
            nodes = "hdfs"
    )
    public static final class Hdfs extends EndpointDeserializers.To {
        public Hdfs() {
            super("hdfs");
        }
    }

    @YamlType(
            nodes = "http"
    )
    public static final class Http extends EndpointDeserializers.To {
        public Http() {
            super("http");
        }
    }

    @YamlType(
            nodes = "https"
    )
    public static final class Https extends EndpointDeserializers.To {
        public Https() {
            super("https");
        }
    }

    @YamlType(
            nodes = "hwcloud-smn"
    )
    public static final class HwcloudSmn extends EndpointDeserializers.To {
        public HwcloudSmn() {
            super("hwcloud-smn");
        }
    }

    @YamlType(
            nodes = "iec60870-client"
    )
    public static final class Iec60870Client extends EndpointDeserializers.To {
        public Iec60870Client() {
            super("iec60870-client");
        }
    }

    @YamlType(
            nodes = "iec60870-server"
    )
    public static final class Iec60870Server extends EndpointDeserializers.To {
        public Iec60870Server() {
            super("iec60870-server");
        }
    }

    @YamlType(
            nodes = "ignite-cache"
    )
    public static final class IgniteCache extends EndpointDeserializers.To {
        public IgniteCache() {
            super("ignite-cache");
        }
    }

    @YamlType(
            nodes = "ignite-compute"
    )
    public static final class IgniteCompute extends EndpointDeserializers.To {
        public IgniteCompute() {
            super("ignite-compute");
        }
    }

    @YamlType(
            nodes = "ignite-idgen"
    )
    public static final class IgniteIdgen extends EndpointDeserializers.To {
        public IgniteIdgen() {
            super("ignite-idgen");
        }
    }

    @YamlType(
            nodes = "ignite-messaging"
    )
    public static final class IgniteMessaging extends EndpointDeserializers.To {
        public IgniteMessaging() {
            super("ignite-messaging");
        }
    }

    @YamlType(
            nodes = "ignite-queue"
    )
    public static final class IgniteQueue extends EndpointDeserializers.To {
        public IgniteQueue() {
            super("ignite-queue");
        }
    }

    @YamlType(
            nodes = "ignite-set"
    )
    public static final class IgniteSet extends EndpointDeserializers.To {
        public IgniteSet() {
            super("ignite-set");
        }
    }

    @YamlType(
            nodes = "imap"
    )
    public static final class Imap extends EndpointDeserializers.To {
        public Imap() {
            super("imap");
        }
    }

    @YamlType(
            nodes = "imaps"
    )
    public static final class Imaps extends EndpointDeserializers.To {
        public Imaps() {
            super("imaps");
        }
    }

    @YamlType(
            nodes = "infinispan"
    )
    public static final class Infinispan extends EndpointDeserializers.To {
        public Infinispan() {
            super("infinispan");
        }
    }

    @YamlType(
            nodes = "infinispan-embedded"
    )
    public static final class InfinispanEmbedded extends EndpointDeserializers.To {
        public InfinispanEmbedded() {
            super("infinispan-embedded");
        }
    }

    @YamlType(
            nodes = "influxdb"
    )
    public static final class Influxdb extends EndpointDeserializers.To {
        public Influxdb() {
            super("influxdb");
        }
    }

    @YamlType(
            nodes = "iota"
    )
    public static final class Iota extends EndpointDeserializers.To {
        public Iota() {
            super("iota");
        }
    }

    @YamlType(
            nodes = "ipfs"
    )
    public static final class Ipfs extends EndpointDeserializers.To {
        public Ipfs() {
            super("ipfs");
        }
    }

    @YamlType(
            nodes = "irc"
    )
    public static final class Irc extends EndpointDeserializers.To {
        public Irc() {
            super("irc");
        }
    }

    @YamlType(
            nodes = "ironmq"
    )
    public static final class Ironmq extends EndpointDeserializers.To {
        public Ironmq() {
            super("ironmq");
        }
    }

    @YamlType(
            nodes = "jbpm"
    )
    public static final class Jbpm extends EndpointDeserializers.To {
        public Jbpm() {
            super("jbpm");
        }
    }

    @YamlType(
            nodes = "jcache"
    )
    public static final class Jcache extends EndpointDeserializers.To {
        public Jcache() {
            super("jcache");
        }
    }

    @YamlType(
            nodes = "jclouds"
    )
    public static final class Jclouds extends EndpointDeserializers.To {
        public Jclouds() {
            super("jclouds");
        }
    }

    @YamlType(
            nodes = "jcr"
    )
    public static final class Jcr extends EndpointDeserializers.To {
        public Jcr() {
            super("jcr");
        }
    }

    @YamlType(
            nodes = "jdbc"
    )
    public static final class Jdbc extends EndpointDeserializers.To {
        public Jdbc() {
            super("jdbc");
        }
    }

    @YamlType(
            nodes = "jgroups"
    )
    public static final class Jgroups extends EndpointDeserializers.To {
        public Jgroups() {
            super("jgroups");
        }
    }

    @YamlType(
            nodes = "jgroups-raft"
    )
    public static final class JgroupsRaft extends EndpointDeserializers.To {
        public JgroupsRaft() {
            super("jgroups-raft");
        }
    }

    @YamlType(
            nodes = "jing"
    )
    public static final class Jing extends EndpointDeserializers.To {
        public Jing() {
            super("jing");
        }
    }

    @YamlType(
            nodes = "jira"
    )
    public static final class Jira extends EndpointDeserializers.To {
        public Jira() {
            super("jira");
        }
    }

    @YamlType(
            nodes = "jms"
    )
    public static final class Jms extends EndpointDeserializers.To {
        public Jms() {
            super("jms");
        }
    }

    @YamlType(
            nodes = "jolt"
    )
    public static final class Jolt extends EndpointDeserializers.To {
        public Jolt() {
            super("jolt");
        }
    }

    @YamlType(
            nodes = "jooq"
    )
    public static final class Jooq extends EndpointDeserializers.To {
        public Jooq() {
            super("jooq");
        }
    }

    @YamlType(
            nodes = "jpa"
    )
    public static final class Jpa extends EndpointDeserializers.To {
        public Jpa() {
            super("jpa");
        }
    }

    @YamlType(
            nodes = "jslt"
    )
    public static final class Jslt extends EndpointDeserializers.To {
        public Jslt() {
            super("jslt");
        }
    }

    @YamlType(
            nodes = "json-validator"
    )
    public static final class JsonValidator extends EndpointDeserializers.To {
        public JsonValidator() {
            super("json-validator");
        }
    }

    @YamlType(
            nodes = "jsonata"
    )
    public static final class Jsonata extends EndpointDeserializers.To {
        public Jsonata() {
            super("jsonata");
        }
    }

    @YamlType(
            nodes = "jt400"
    )
    public static final class Jt400 extends EndpointDeserializers.To {
        public Jt400() {
            super("jt400");
        }
    }

    @YamlType(
            nodes = "kafka"
    )
    public static final class Kafka extends EndpointDeserializers.To {
        public Kafka() {
            super("kafka");
        }
    }

    @YamlType(
            nodes = "kamelet"
    )
    public static final class Kamelet extends EndpointDeserializers.To {
        public Kamelet() {
            super("kamelet");
        }
    }

    @YamlType(
            nodes = "kubernetes-config-maps"
    )
    public static final class KubernetesConfigMaps extends EndpointDeserializers.To {
        public KubernetesConfigMaps() {
            super("kubernetes-config-maps");
        }
    }

    @YamlType(
            nodes = "kubernetes-custom-resources"
    )
    public static final class KubernetesCustomResources extends EndpointDeserializers.To {
        public KubernetesCustomResources() {
            super("kubernetes-custom-resources");
        }
    }

    @YamlType(
            nodes = "kubernetes-deployments"
    )
    public static final class KubernetesDeployments extends EndpointDeserializers.To {
        public KubernetesDeployments() {
            super("kubernetes-deployments");
        }
    }

    @YamlType(
            nodes = "kubernetes-hpa"
    )
    public static final class KubernetesHpa extends EndpointDeserializers.To {
        public KubernetesHpa() {
            super("kubernetes-hpa");
        }
    }

    @YamlType(
            nodes = "kubernetes-job"
    )
    public static final class KubernetesJob extends EndpointDeserializers.To {
        public KubernetesJob() {
            super("kubernetes-job");
        }
    }

    @YamlType(
            nodes = "kubernetes-namespaces"
    )
    public static final class KubernetesNamespaces extends EndpointDeserializers.To {
        public KubernetesNamespaces() {
            super("kubernetes-namespaces");
        }
    }

    @YamlType(
            nodes = "kubernetes-nodes"
    )
    public static final class KubernetesNodes extends EndpointDeserializers.To {
        public KubernetesNodes() {
            super("kubernetes-nodes");
        }
    }

    @YamlType(
            nodes = "kubernetes-persistent-volumes"
    )
    public static final class KubernetesPersistentVolumes extends EndpointDeserializers.To {
        public KubernetesPersistentVolumes() {
            super("kubernetes-persistent-volumes");
        }
    }

    @YamlType(
            nodes = "kubernetes-persistent-volumes-claims"
    )
    public static final class KubernetesPersistentVolumesClaims extends EndpointDeserializers.To {
        public KubernetesPersistentVolumesClaims() {
            super("kubernetes-persistent-volumes-claims");
        }
    }

    @YamlType(
            nodes = "kubernetes-pods"
    )
    public static final class KubernetesPods extends EndpointDeserializers.To {
        public KubernetesPods() {
            super("kubernetes-pods");
        }
    }

    @YamlType(
            nodes = "kubernetes-replication-controllers"
    )
    public static final class KubernetesReplicationControllers extends EndpointDeserializers.To {
        public KubernetesReplicationControllers() {
            super("kubernetes-replication-controllers");
        }
    }

    @YamlType(
            nodes = "kubernetes-resources-quota"
    )
    public static final class KubernetesResourcesQuota extends EndpointDeserializers.To {
        public KubernetesResourcesQuota() {
            super("kubernetes-resources-quota");
        }
    }

    @YamlType(
            nodes = "kubernetes-secrets"
    )
    public static final class KubernetesSecrets extends EndpointDeserializers.To {
        public KubernetesSecrets() {
            super("kubernetes-secrets");
        }
    }

    @YamlType(
            nodes = "kubernetes-service-accounts"
    )
    public static final class KubernetesServiceAccounts extends EndpointDeserializers.To {
        public KubernetesServiceAccounts() {
            super("kubernetes-service-accounts");
        }
    }

    @YamlType(
            nodes = "kubernetes-services"
    )
    public static final class KubernetesServices extends EndpointDeserializers.To {
        public KubernetesServices() {
            super("kubernetes-services");
        }
    }

    @YamlType(
            nodes = "kudu"
    )
    public static final class Kudu extends EndpointDeserializers.To {
        public Kudu() {
            super("kudu");
        }
    }

    @YamlType(
            nodes = "language"
    )
    public static final class Language extends EndpointDeserializers.To {
        public Language() {
            super("language");
        }
    }

    @YamlType(
            nodes = "ldap"
    )
    public static final class Ldap extends EndpointDeserializers.To {
        public Ldap() {
            super("ldap");
        }
    }

    @YamlType(
            nodes = "ldif"
    )
    public static final class Ldif extends EndpointDeserializers.To {
        public Ldif() {
            super("ldif");
        }
    }

    @YamlType(
            nodes = "log"
    )
    public static final class Log extends EndpointDeserializers.To {
        public Log() {
            super("log");
        }
    }

    @YamlType(
            nodes = "lpr"
    )
    public static final class Lpr extends EndpointDeserializers.To {
        public Lpr() {
            super("lpr");
        }
    }

    @YamlType(
            nodes = "lucene"
    )
    public static final class Lucene extends EndpointDeserializers.To {
        public Lucene() {
            super("lucene");
        }
    }

    @YamlType(
            nodes = "metrics"
    )
    public static final class Metrics extends EndpointDeserializers.To {
        public Metrics() {
            super("metrics");
        }
    }

    @YamlType(
            nodes = "micrometer"
    )
    public static final class Micrometer extends EndpointDeserializers.To {
        public Micrometer() {
            super("micrometer");
        }
    }

    @YamlType(
            nodes = "microprofile-metrics"
    )
    public static final class MicroprofileMetrics extends EndpointDeserializers.To {
        public MicroprofileMetrics() {
            super("microprofile-metrics");
        }
    }

    @YamlType(
            nodes = "milo-client"
    )
    public static final class MiloClient extends EndpointDeserializers.To {
        public MiloClient() {
            super("milo-client");
        }
    }

    @YamlType(
            nodes = "milo-server"
    )
    public static final class MiloServer extends EndpointDeserializers.To {
        public MiloServer() {
            super("milo-server");
        }
    }

    @YamlType(
            nodes = "mina"
    )
    public static final class Mina extends EndpointDeserializers.To {
        public Mina() {
            super("mina");
        }
    }

    @YamlType(
            nodes = "minio"
    )
    public static final class Minio extends EndpointDeserializers.To {
        public Minio() {
            super("minio");
        }
    }

    @YamlType(
            nodes = "mllp"
    )
    public static final class Mllp extends EndpointDeserializers.To {
        public Mllp() {
            super("mllp");
        }
    }

    @YamlType(
            nodes = "mock"
    )
    public static final class Mock extends EndpointDeserializers.To {
        public Mock() {
            super("mock");
        }
    }

    @YamlType(
            nodes = "mongodb"
    )
    public static final class Mongodb extends EndpointDeserializers.To {
        public Mongodb() {
            super("mongodb");
        }
    }

    @YamlType(
            nodes = "mongodb-gridfs"
    )
    public static final class MongodbGridfs extends EndpointDeserializers.To {
        public MongodbGridfs() {
            super("mongodb-gridfs");
        }
    }

    @YamlType(
            nodes = "msv"
    )
    public static final class Msv extends EndpointDeserializers.To {
        public Msv() {
            super("msv");
        }
    }

    @YamlType(
            nodes = "mustache"
    )
    public static final class Mustache extends EndpointDeserializers.To {
        public Mustache() {
            super("mustache");
        }
    }

    @YamlType(
            nodes = "mvel"
    )
    public static final class Mvel extends EndpointDeserializers.To {
        public Mvel() {
            super("mvel");
        }
    }

    @YamlType(
            nodes = "mybatis"
    )
    public static final class Mybatis extends EndpointDeserializers.To {
        public Mybatis() {
            super("mybatis");
        }
    }

    @YamlType(
            nodes = "mybatis-bean"
    )
    public static final class MybatisBean extends EndpointDeserializers.To {
        public MybatisBean() {
            super("mybatis-bean");
        }
    }

    @YamlType(
            nodes = "nagios"
    )
    public static final class Nagios extends EndpointDeserializers.To {
        public Nagios() {
            super("nagios");
        }
    }

    @YamlType(
            nodes = "nats"
    )
    public static final class Nats extends EndpointDeserializers.To {
        public Nats() {
            super("nats");
        }
    }

    @YamlType(
            nodes = "netty"
    )
    public static final class Netty extends EndpointDeserializers.To {
        public Netty() {
            super("netty");
        }
    }

    @YamlType(
            nodes = "netty-http"
    )
    public static final class NettyHttp extends EndpointDeserializers.To {
        public NettyHttp() {
            super("netty-http");
        }
    }

    @YamlType(
            nodes = "nitrite"
    )
    public static final class Nitrite extends EndpointDeserializers.To {
        public Nitrite() {
            super("nitrite");
        }
    }

    @YamlType(
            nodes = "nsq"
    )
    public static final class Nsq extends EndpointDeserializers.To {
        public Nsq() {
            super("nsq");
        }
    }

    @YamlType(
            nodes = "oaipmh"
    )
    public static final class Oaipmh extends EndpointDeserializers.To {
        public Oaipmh() {
            super("oaipmh");
        }
    }

    @YamlType(
            nodes = "olingo2"
    )
    public static final class Olingo2 extends EndpointDeserializers.To {
        public Olingo2() {
            super("olingo2");
        }
    }

    @YamlType(
            nodes = "olingo4"
    )
    public static final class Olingo4 extends EndpointDeserializers.To {
        public Olingo4() {
            super("olingo4");
        }
    }

    @YamlType(
            nodes = "openshift-build-configs"
    )
    public static final class OpenshiftBuildConfigs extends EndpointDeserializers.To {
        public OpenshiftBuildConfigs() {
            super("openshift-build-configs");
        }
    }

    @YamlType(
            nodes = "openshift-builds"
    )
    public static final class OpenshiftBuilds extends EndpointDeserializers.To {
        public OpenshiftBuilds() {
            super("openshift-builds");
        }
    }

    @YamlType(
            nodes = "openstack-cinder"
    )
    public static final class OpenstackCinder extends EndpointDeserializers.To {
        public OpenstackCinder() {
            super("openstack-cinder");
        }
    }

    @YamlType(
            nodes = "openstack-glance"
    )
    public static final class OpenstackGlance extends EndpointDeserializers.To {
        public OpenstackGlance() {
            super("openstack-glance");
        }
    }

    @YamlType(
            nodes = "openstack-keystone"
    )
    public static final class OpenstackKeystone extends EndpointDeserializers.To {
        public OpenstackKeystone() {
            super("openstack-keystone");
        }
    }

    @YamlType(
            nodes = "openstack-neutron"
    )
    public static final class OpenstackNeutron extends EndpointDeserializers.To {
        public OpenstackNeutron() {
            super("openstack-neutron");
        }
    }

    @YamlType(
            nodes = "openstack-nova"
    )
    public static final class OpenstackNova extends EndpointDeserializers.To {
        public OpenstackNova() {
            super("openstack-nova");
        }
    }

    @YamlType(
            nodes = "openstack-swift"
    )
    public static final class OpenstackSwift extends EndpointDeserializers.To {
        public OpenstackSwift() {
            super("openstack-swift");
        }
    }

    @YamlType(
            nodes = "optaplanner"
    )
    public static final class Optaplanner extends EndpointDeserializers.To {
        public Optaplanner() {
            super("optaplanner");
        }
    }

    @YamlType(
            nodes = "paho"
    )
    public static final class Paho extends EndpointDeserializers.To {
        public Paho() {
            super("paho");
        }
    }

    @YamlType(
            nodes = "paho-mqtt5"
    )
    public static final class PahoMqtt5 extends EndpointDeserializers.To {
        public PahoMqtt5() {
            super("paho-mqtt5");
        }
    }

    @YamlType(
            nodes = "pdf"
    )
    public static final class Pdf extends EndpointDeserializers.To {
        public Pdf() {
            super("pdf");
        }
    }

    @YamlType(
            nodes = "pgevent"
    )
    public static final class Pgevent extends EndpointDeserializers.To {
        public Pgevent() {
            super("pgevent");
        }
    }

    @YamlType(
            nodes = "pop3"
    )
    public static final class Pop3 extends EndpointDeserializers.To {
        public Pop3() {
            super("pop3");
        }
    }

    @YamlType(
            nodes = "pop3s"
    )
    public static final class Pop3s extends EndpointDeserializers.To {
        public Pop3s() {
            super("pop3s");
        }
    }

    @YamlType(
            nodes = "pubnub"
    )
    public static final class Pubnub extends EndpointDeserializers.To {
        public Pubnub() {
            super("pubnub");
        }
    }

    @YamlType(
            nodes = "pulsar"
    )
    public static final class Pulsar extends EndpointDeserializers.To {
        public Pulsar() {
            super("pulsar");
        }
    }

    @YamlType(
            nodes = "quickfix"
    )
    public static final class Quickfix extends EndpointDeserializers.To {
        public Quickfix() {
            super("quickfix");
        }
    }

    @YamlType(
            nodes = "rabbitmq"
    )
    public static final class Rabbitmq extends EndpointDeserializers.To {
        public Rabbitmq() {
            super("rabbitmq");
        }
    }

    @YamlType(
            nodes = "reactive-streams"
    )
    public static final class ReactiveStreams extends EndpointDeserializers.To {
        public ReactiveStreams() {
            super("reactive-streams");
        }
    }

    @YamlType(
            nodes = "ref"
    )
    public static final class Ref extends EndpointDeserializers.To {
        public Ref() {
            super("ref");
        }
    }

    @YamlType(
            nodes = "rest"
    )
    public static final class Rest extends EndpointDeserializers.To {
        public Rest() {
            super("rest");
        }
    }

    @YamlType(
            nodes = "rest-openapi"
    )
    public static final class RestOpenapi extends EndpointDeserializers.To {
        public RestOpenapi() {
            super("rest-openapi");
        }
    }

    @YamlType(
            nodes = "rest-swagger"
    )
    public static final class RestSwagger extends EndpointDeserializers.To {
        public RestSwagger() {
            super("rest-swagger");
        }
    }

    @YamlType(
            nodes = "resteasy"
    )
    public static final class Resteasy extends EndpointDeserializers.To {
        public Resteasy() {
            super("resteasy");
        }
    }

    @YamlType(
            nodes = "robotframework"
    )
    public static final class Robotframework extends EndpointDeserializers.To {
        public Robotframework() {
            super("robotframework");
        }
    }

    @YamlType(
            nodes = "saga"
    )
    public static final class Saga extends EndpointDeserializers.To {
        public Saga() {
            super("saga");
        }
    }

    @YamlType(
            nodes = "salesforce"
    )
    public static final class Salesforce extends EndpointDeserializers.To {
        public Salesforce() {
            super("salesforce");
        }
    }

    @YamlType(
            nodes = "sap-netweaver"
    )
    public static final class SapNetweaver extends EndpointDeserializers.To {
        public SapNetweaver() {
            super("sap-netweaver");
        }
    }

    @YamlType(
            nodes = "schematron"
    )
    public static final class Schematron extends EndpointDeserializers.To {
        public Schematron() {
            super("schematron");
        }
    }

    @YamlType(
            nodes = "scp"
    )
    public static final class Scp extends EndpointDeserializers.To {
        public Scp() {
            super("scp");
        }
    }

    @YamlType(
            nodes = "seda"
    )
    public static final class Seda extends EndpointDeserializers.To {
        public Seda() {
            super("seda");
        }
    }

    @YamlType(
            nodes = "servicenow"
    )
    public static final class Servicenow extends EndpointDeserializers.To {
        public Servicenow() {
            super("servicenow");
        }
    }

    @YamlType(
            nodes = "sftp"
    )
    public static final class Sftp extends EndpointDeserializers.To {
        public Sftp() {
            super("sftp");
        }
    }

    @YamlType(
            nodes = "sip"
    )
    public static final class Sip extends EndpointDeserializers.To {
        public Sip() {
            super("sip");
        }
    }

    @YamlType(
            nodes = "sips"
    )
    public static final class Sips extends EndpointDeserializers.To {
        public Sips() {
            super("sips");
        }
    }

    @YamlType(
            nodes = "sjms"
    )
    public static final class Sjms extends EndpointDeserializers.To {
        public Sjms() {
            super("sjms");
        }
    }

    @YamlType(
            nodes = "sjms2"
    )
    public static final class Sjms2 extends EndpointDeserializers.To {
        public Sjms2() {
            super("sjms2");
        }
    }

    @YamlType(
            nodes = "slack"
    )
    public static final class Slack extends EndpointDeserializers.To {
        public Slack() {
            super("slack");
        }
    }

    @YamlType(
            nodes = "smpp"
    )
    public static final class Smpp extends EndpointDeserializers.To {
        public Smpp() {
            super("smpp");
        }
    }

    @YamlType(
            nodes = "smpps"
    )
    public static final class Smpps extends EndpointDeserializers.To {
        public Smpps() {
            super("smpps");
        }
    }

    @YamlType(
            nodes = "smtp"
    )
    public static final class Smtp extends EndpointDeserializers.To {
        public Smtp() {
            super("smtp");
        }
    }

    @YamlType(
            nodes = "smtps"
    )
    public static final class Smtps extends EndpointDeserializers.To {
        public Smtps() {
            super("smtps");
        }
    }

    @YamlType(
            nodes = "snmp"
    )
    public static final class Snmp extends EndpointDeserializers.To {
        public Snmp() {
            super("snmp");
        }
    }

    @YamlType(
            nodes = "solr"
    )
    public static final class Solr extends EndpointDeserializers.To {
        public Solr() {
            super("solr");
        }
    }

    @YamlType(
            nodes = "solrCloud"
    )
    public static final class SolrCloud extends EndpointDeserializers.To {
        public SolrCloud() {
            super("solrCloud");
        }
    }

    @YamlType(
            nodes = "solrs"
    )
    public static final class Solrs extends EndpointDeserializers.To {
        public Solrs() {
            super("solrs");
        }
    }

    @YamlType(
            nodes = "soroush"
    )
    public static final class Soroush extends EndpointDeserializers.To {
        public Soroush() {
            super("soroush");
        }
    }

    @YamlType(
            nodes = "spark"
    )
    public static final class Spark extends EndpointDeserializers.To {
        public Spark() {
            super("spark");
        }
    }

    @YamlType(
            nodes = "splunk"
    )
    public static final class Splunk extends EndpointDeserializers.To {
        public Splunk() {
            super("splunk");
        }
    }

    @YamlType(
            nodes = "splunk-hec"
    )
    public static final class SplunkHec extends EndpointDeserializers.To {
        public SplunkHec() {
            super("splunk-hec");
        }
    }

    @YamlType(
            nodes = "spring-batch"
    )
    public static final class SpringBatch extends EndpointDeserializers.To {
        public SpringBatch() {
            super("spring-batch");
        }
    }

    @YamlType(
            nodes = "spring-event"
    )
    public static final class SpringEvent extends EndpointDeserializers.To {
        public SpringEvent() {
            super("spring-event");
        }
    }

    @YamlType(
            nodes = "spring-integration"
    )
    public static final class SpringIntegration extends EndpointDeserializers.To {
        public SpringIntegration() {
            super("spring-integration");
        }
    }

    @YamlType(
            nodes = "spring-ldap"
    )
    public static final class SpringLdap extends EndpointDeserializers.To {
        public SpringLdap() {
            super("spring-ldap");
        }
    }

    @YamlType(
            nodes = "spring-rabbitmq"
    )
    public static final class SpringRabbitmq extends EndpointDeserializers.To {
        public SpringRabbitmq() {
            super("spring-rabbitmq");
        }
    }

    @YamlType(
            nodes = "spring-redis"
    )
    public static final class SpringRedis extends EndpointDeserializers.To {
        public SpringRedis() {
            super("spring-redis");
        }
    }

    @YamlType(
            nodes = "spring-ws"
    )
    public static final class SpringWs extends EndpointDeserializers.To {
        public SpringWs() {
            super("spring-ws");
        }
    }

    @YamlType(
            nodes = "sql"
    )
    public static final class Sql extends EndpointDeserializers.To {
        public Sql() {
            super("sql");
        }
    }

    @YamlType(
            nodes = "sql-stored"
    )
    public static final class SqlStored extends EndpointDeserializers.To {
        public SqlStored() {
            super("sql-stored");
        }
    }

    @YamlType(
            nodes = "ssh"
    )
    public static final class Ssh extends EndpointDeserializers.To {
        public Ssh() {
            super("ssh");
        }
    }

    @YamlType(
            nodes = "stax"
    )
    public static final class Stax extends EndpointDeserializers.To {
        public Stax() {
            super("stax");
        }
    }

    @YamlType(
            nodes = "stitch"
    )
    public static final class Stitch extends EndpointDeserializers.To {
        public Stitch() {
            super("stitch");
        }
    }

    @YamlType(
            nodes = "stomp"
    )
    public static final class Stomp extends EndpointDeserializers.To {
        public Stomp() {
            super("stomp");
        }
    }

    @YamlType(
            nodes = "stream"
    )
    public static final class Stream extends EndpointDeserializers.To {
        public Stream() {
            super("stream");
        }
    }

    @YamlType(
            nodes = "string-template"
    )
    public static final class StringTemplate extends EndpointDeserializers.To {
        public StringTemplate() {
            super("string-template");
        }
    }

    @YamlType(
            nodes = "stub"
    )
    public static final class Stub extends EndpointDeserializers.To {
        public Stub() {
            super("stub");
        }
    }

    @YamlType(
            nodes = "telegram"
    )
    public static final class Telegram extends EndpointDeserializers.To {
        public Telegram() {
            super("telegram");
        }
    }

    @YamlType(
            nodes = "thrift"
    )
    public static final class Thrift extends EndpointDeserializers.To {
        public Thrift() {
            super("thrift");
        }
    }

    @YamlType(
            nodes = "tika"
    )
    public static final class Tika extends EndpointDeserializers.To {
        public Tika() {
            super("tika");
        }
    }

    @YamlType(
            nodes = "twilio"
    )
    public static final class Twilio extends EndpointDeserializers.To {
        public Twilio() {
            super("twilio");
        }
    }

    @YamlType(
            nodes = "twitter-directmessage"
    )
    public static final class TwitterDirectmessage extends EndpointDeserializers.To {
        public TwitterDirectmessage() {
            super("twitter-directmessage");
        }
    }

    @YamlType(
            nodes = "twitter-search"
    )
    public static final class TwitterSearch extends EndpointDeserializers.To {
        public TwitterSearch() {
            super("twitter-search");
        }
    }

    @YamlType(
            nodes = "twitter-timeline"
    )
    public static final class TwitterTimeline extends EndpointDeserializers.To {
        public TwitterTimeline() {
            super("twitter-timeline");
        }
    }

    @YamlType(
            nodes = "undertow"
    )
    public static final class Undertow extends EndpointDeserializers.To {
        public Undertow() {
            super("undertow");
        }
    }

    @YamlType(
            nodes = "validator"
    )
    public static final class Validator extends EndpointDeserializers.To {
        public Validator() {
            super("validator");
        }
    }

    @YamlType(
            nodes = "velocity"
    )
    public static final class Velocity extends EndpointDeserializers.To {
        public Velocity() {
            super("velocity");
        }
    }

    @YamlType(
            nodes = "vertx"
    )
    public static final class Vertx extends EndpointDeserializers.To {
        public Vertx() {
            super("vertx");
        }
    }

    @YamlType(
            nodes = "vertx-http"
    )
    public static final class VertxHttp extends EndpointDeserializers.To {
        public VertxHttp() {
            super("vertx-http");
        }
    }

    @YamlType(
            nodes = "vertx-kafka"
    )
    public static final class VertxKafka extends EndpointDeserializers.To {
        public VertxKafka() {
            super("vertx-kafka");
        }
    }

    @YamlType(
            nodes = "vertx-websocket"
    )
    public static final class VertxWebsocket extends EndpointDeserializers.To {
        public VertxWebsocket() {
            super("vertx-websocket");
        }
    }

    @YamlType(
            nodes = "vm"
    )
    public static final class Vm extends EndpointDeserializers.To {
        public Vm() {
            super("vm");
        }
    }

    @YamlType(
            nodes = "weather"
    )
    public static final class Weather extends EndpointDeserializers.To {
        public Weather() {
            super("weather");
        }
    }

    @YamlType(
            nodes = "web3j"
    )
    public static final class Web3j extends EndpointDeserializers.To {
        public Web3j() {
            super("web3j");
        }
    }

    @YamlType(
            nodes = "websocket"
    )
    public static final class Websocket extends EndpointDeserializers.To {
        public Websocket() {
            super("websocket");
        }
    }

    @YamlType(
            nodes = "websocket-jsr356"
    )
    public static final class WebsocketJsr356 extends EndpointDeserializers.To {
        public WebsocketJsr356() {
            super("websocket-jsr356");
        }
    }

    @YamlType(
            nodes = "weka"
    )
    public static final class Weka extends EndpointDeserializers.To {
        public Weka() {
            super("weka");
        }
    }

    @YamlType(
            nodes = "wordpress"
    )
    public static final class Wordpress extends EndpointDeserializers.To {
        public Wordpress() {
            super("wordpress");
        }
    }

    @YamlType(
            nodes = "workday"
    )
    public static final class Workday extends EndpointDeserializers.To {
        public Workday() {
            super("workday");
        }
    }

    @YamlType(
            nodes = "xchange"
    )
    public static final class Xchange extends EndpointDeserializers.To {
        public Xchange() {
            super("xchange");
        }
    }

    @YamlType(
            nodes = "xj"
    )
    public static final class Xj extends EndpointDeserializers.To {
        public Xj() {
            super("xj");
        }
    }

    @YamlType(
            nodes = "xmlsecurity-sign"
    )
    public static final class XmlsecuritySign extends EndpointDeserializers.To {
        public XmlsecuritySign() {
            super("xmlsecurity-sign");
        }
    }

    @YamlType(
            nodes = "xmlsecurity-verify"
    )
    public static final class XmlsecurityVerify extends EndpointDeserializers.To {
        public XmlsecurityVerify() {
            super("xmlsecurity-verify");
        }
    }

    @YamlType(
            nodes = "xmpp"
    )
    public static final class Xmpp extends EndpointDeserializers.To {
        public Xmpp() {
            super("xmpp");
        }
    }

    @YamlType(
            nodes = "xquery"
    )
    public static final class Xquery extends EndpointDeserializers.To {
        public Xquery() {
            super("xquery");
        }
    }

    @YamlType(
            nodes = "xslt"
    )
    public static final class Xslt extends EndpointDeserializers.To {
        public Xslt() {
            super("xslt");
        }
    }

    @YamlType(
            nodes = "xslt-saxon"
    )
    public static final class XsltSaxon extends EndpointDeserializers.To {
        public XsltSaxon() {
            super("xslt-saxon");
        }
    }

    @YamlType(
            nodes = "yammer"
    )
    public static final class Yammer extends EndpointDeserializers.To {
        public Yammer() {
            super("yammer");
        }
    }

    @YamlType(
            nodes = "zendesk"
    )
    public static final class Zendesk extends EndpointDeserializers.To {
        public Zendesk() {
            super("zendesk");
        }
    }

    @YamlType(
            nodes = "zookeeper"
    )
    public static final class Zookeeper extends EndpointDeserializers.To {
        public Zookeeper() {
            super("zookeeper");
        }
    }
}
