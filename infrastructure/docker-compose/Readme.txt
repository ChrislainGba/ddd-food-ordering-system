#run zookeeper
docker-compose -f common.yml -f zookeeper.yml up
#run kafka in new terminal
docker-compose -f common.yml -f kafka_cluster.yml up
# open kfka manager using http://localhost:9000