change volumes permissions

docker compose -f common.yml -f zookeeper.yml up

echo ruok | nc localhost 2181 - > to check = expected 'imok'

docker compose -f common.yml -f kafka_cluster.yml up

docker compose -f common.yml -f init_kafka.yml up