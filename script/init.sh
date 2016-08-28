#!/usr/bin/env bash
ES_HOST=http://127.0.0.1:9200
curl -XPUT ${ES_HOST}/minitcp -d '
{
   "settings" : {
      "number_of_shards" : 3,
      "number_of_replicas" : 1
   }
}'