/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hdfs.client;

import org.apache.hadoop.classification.InterfaceAudience;

import java.util.concurrent.TimeUnit;

/** Client configuration properties */
@InterfaceAudience.Private
public interface HdfsClientConfigKeys {
  long SECOND = 1000L;
  long MINUTE = 60 * SECOND;

  String  DFS_BLOCK_SIZE_KEY = "dfs.blocksize";
  long    DFS_BLOCK_SIZE_DEFAULT = 128*1024*1024;
  String  DFS_REPLICATION_KEY = "dfs.replication";
  short   DFS_REPLICATION_DEFAULT = 3;
  String  DFS_WEBHDFS_USER_PATTERN_KEY = "dfs.webhdfs.user.provider.user.pattern";
  String  DFS_WEBHDFS_USER_PATTERN_DEFAULT = "^[A-Za-z_][A-Za-z0-9._-]*[$]?$";
  String DFS_WEBHDFS_ACL_PERMISSION_PATTERN_DEFAULT =
      "^(default:)?(user|group|mask|other):[[A-Za-z_][A-Za-z0-9._-]]*:([rwx-]{3})?(,(default:)?(user|group|mask|other):[[A-Za-z_][A-Za-z0-9._-]]*:([rwx-]{3})?)*$";

  String PREFIX = "dfs.client.";
  String  DFS_NAMESERVICES = "dfs.nameservices";
  int     DFS_NAMENODE_HTTP_PORT_DEFAULT = 50070;
  String  DFS_NAMENODE_HTTP_ADDRESS_KEY = "dfs.namenode.http-address";
  int     DFS_NAMENODE_HTTPS_PORT_DEFAULT = 50470;
  String  DFS_NAMENODE_HTTPS_ADDRESS_KEY = "dfs.namenode.https-address";
  String DFS_HA_NAMENODES_KEY_PREFIX = "dfs.ha.namenodes";
  int DFS_NAMENODE_RPC_PORT_DEFAULT = 8020;
  String DFS_NAMENODE_KERBEROS_PRINCIPAL_KEY =
      "dfs.namenode.kerberos.principal";
  String  DFS_CLIENT_WRITE_PACKET_SIZE_KEY = "dfs.client-write-packet-size";
  int     DFS_CLIENT_WRITE_PACKET_SIZE_DEFAULT = 64*1024;
  String  DFS_CLIENT_SOCKET_TIMEOUT_KEY = "dfs.client.socket-timeout";
  String  DFS_CLIENT_SOCKET_CACHE_CAPACITY_KEY =
      "dfs.client.socketcache.capacity";
  int     DFS_CLIENT_SOCKET_CACHE_CAPACITY_DEFAULT = 16;
  String  DFS_CLIENT_SOCKET_CACHE_EXPIRY_MSEC_KEY =
      "dfs.client.socketcache.expiryMsec";
  long    DFS_CLIENT_SOCKET_CACHE_EXPIRY_MSEC_DEFAULT = 3000;
  String  DFS_CLIENT_USE_DN_HOSTNAME = "dfs.client.use.datanode.hostname";
  boolean DFS_CLIENT_USE_DN_HOSTNAME_DEFAULT = false;
  String  DFS_CLIENT_CACHE_DROP_BEHIND_WRITES =
      "dfs.client.cache.drop.behind.writes";
  String  DFS_CLIENT_CACHE_DROP_BEHIND_READS =
      "dfs.client.cache.drop.behind.reads";
  String  DFS_CLIENT_CACHE_READAHEAD = "dfs.client.cache.readahead";
  String  DFS_CLIENT_CACHED_CONN_RETRY_KEY = "dfs.client.cached.conn.retry";
  int     DFS_CLIENT_CACHED_CONN_RETRY_DEFAULT = 3;
  String  DFS_CLIENT_CONTEXT = "dfs.client.context";
  String  DFS_CLIENT_CONTEXT_DEFAULT = "default";
  String  DFS_CLIENT_FILE_BLOCK_STORAGE_LOCATIONS_NUM_THREADS =
      "dfs.client.file-block-storage-locations.num-threads";
  int     DFS_CLIENT_FILE_BLOCK_STORAGE_LOCATIONS_NUM_THREADS_DEFAULT = 10;
  String  DFS_CLIENT_FILE_BLOCK_STORAGE_LOCATIONS_TIMEOUT_MS =
      "dfs.client.file-block-storage-locations.timeout.millis";
  int     DFS_CLIENT_FILE_BLOCK_STORAGE_LOCATIONS_TIMEOUT_MS_DEFAULT = 1000;
  String  DFS_CLIENT_USE_LEGACY_BLOCKREADER =
      "dfs.client.use.legacy.blockreader";
  boolean DFS_CLIENT_USE_LEGACY_BLOCKREADER_DEFAULT = false;
  String  DFS_CLIENT_USE_LEGACY_BLOCKREADERLOCAL =
      "dfs.client.use.legacy.blockreader.local";
  boolean DFS_CLIENT_USE_LEGACY_BLOCKREADERLOCAL_DEFAULT = false;
  String  DFS_CLIENT_DATANODE_RESTART_TIMEOUT_KEY =
      "dfs.client.datanode-restart.timeout";
  long    DFS_CLIENT_DATANODE_RESTART_TIMEOUT_DEFAULT = 30;
  // Much code in hdfs is not yet updated to use these keys.
  // the initial delay (unit is ms) for locateFollowingBlock, the delay time
  // will increase exponentially(double) for each retry.
  String  DFS_CLIENT_MAX_BLOCK_ACQUIRE_FAILURES_KEY =
      "dfs.client.max.block.acquire.failures";
  int     DFS_CLIENT_MAX_BLOCK_ACQUIRE_FAILURES_DEFAULT = 3;
  String  DFS_CHECKSUM_TYPE_KEY = "dfs.checksum.type";
  String  DFS_CHECKSUM_TYPE_DEFAULT = "CRC32C";
  String  DFS_BYTES_PER_CHECKSUM_KEY = "dfs.bytes-per-checksum";
  int     DFS_BYTES_PER_CHECKSUM_DEFAULT = 512;
  String  DFS_DATANODE_SOCKET_WRITE_TIMEOUT_KEY =
      "dfs.datanode.socket.write.timeout";
  String  DFS_CLIENT_DOMAIN_SOCKET_DATA_TRAFFIC =
      "dfs.client.domain.socket.data.traffic";
  boolean DFS_CLIENT_DOMAIN_SOCKET_DATA_TRAFFIC_DEFAULT = false;
  String  DFS_DOMAIN_SOCKET_PATH_KEY = "dfs.domain.socket.path";
  String  DFS_DOMAIN_SOCKET_PATH_DEFAULT = "";
  String  DFS_SHORT_CIRCUIT_SHARED_MEMORY_WATCHER_INTERRUPT_CHECK_MS =
      "dfs.short.circuit.shared.memory.watcher.interrupt.check.ms";
  int     DFS_SHORT_CIRCUIT_SHARED_MEMORY_WATCHER_INTERRUPT_CHECK_MS_DEFAULT =
      60000;
  String  DFS_CLIENT_SLOW_IO_WARNING_THRESHOLD_KEY =
      "dfs.client.slow.io.warning.threshold.ms";
  long    DFS_CLIENT_SLOW_IO_WARNING_THRESHOLD_DEFAULT = 30000;
  String  DFS_CLIENT_KEY_PROVIDER_CACHE_EXPIRY_MS =
          "dfs.client.key.provider.cache.expiry";
  long    DFS_CLIENT_KEY_PROVIDER_CACHE_EXPIRY_DEFAULT =
              TimeUnit.DAYS.toMillis(10); // 10 days
  String  DFS_HDFS_BLOCKS_METADATA_ENABLED =
      "dfs.datanode.hdfs-blocks-metadata.enabled";
  boolean DFS_HDFS_BLOCKS_METADATA_ENABLED_DEFAULT = false;

  String  DFS_DATANODE_KERBEROS_PRINCIPAL_KEY = "dfs.datanode.kerberos.principal";
  String  DFS_DATANODE_READAHEAD_BYTES_KEY = "dfs.datanode.readahead.bytes";
  long    DFS_DATANODE_READAHEAD_BYTES_DEFAULT = 4 * 1024 * 1024; // 4MB
  String  DFS_ENCRYPTION_KEY_PROVIDER_URI = "dfs.encryption.key.provider.uri";

  String REPLICA_ACCESSOR_BUILDER_CLASSES_KEY =
      PREFIX + "replica.accessor.builder.classes";

  /** dfs.client.retry configuration properties */
  interface Retry {
    String PREFIX = HdfsClientConfigKeys.PREFIX + "retry.";

    String  POLICY_ENABLED_KEY = PREFIX + "policy.enabled";
    boolean POLICY_ENABLED_DEFAULT = false; 
    String  POLICY_SPEC_KEY = PREFIX + "policy.spec";
    String  POLICY_SPEC_DEFAULT = "10000,6,60000,10"; //t1,n1,t2,n2,... 

    String  TIMES_GET_LAST_BLOCK_LENGTH_KEY = PREFIX + "times.get-last-block-length";
    int     TIMES_GET_LAST_BLOCK_LENGTH_DEFAULT = 3;
    String  INTERVAL_GET_LAST_BLOCK_LENGTH_KEY = PREFIX + "interval-ms.get-last-block-length";
    int     INTERVAL_GET_LAST_BLOCK_LENGTH_DEFAULT = 4000;

    String  MAX_ATTEMPTS_KEY = PREFIX + "max.attempts";
    int     MAX_ATTEMPTS_DEFAULT = 10;

    String  WINDOW_BASE_KEY = PREFIX + "window.base";
    int     WINDOW_BASE_DEFAULT = 3000;
  }

  /** dfs.client.failover configuration properties */
  interface Failover {
    String PREFIX = HdfsClientConfigKeys.PREFIX + "failover.";

    String  PROXY_PROVIDER_KEY_PREFIX = PREFIX + "proxy.provider";
    String  MAX_ATTEMPTS_KEY = PREFIX + "max.attempts";
    int     MAX_ATTEMPTS_DEFAULT = 15;
    String  SLEEPTIME_BASE_KEY = PREFIX + "sleep.base.millis";
    int     SLEEPTIME_BASE_DEFAULT = 500;
    String  SLEEPTIME_MAX_KEY = PREFIX + "sleep.max.millis";
    int     SLEEPTIME_MAX_DEFAULT = 15000;
    String  CONNECTION_RETRIES_KEY = PREFIX + "connection.retries";
    int     CONNECTION_RETRIES_DEFAULT = 0;
    String  CONNECTION_RETRIES_ON_SOCKET_TIMEOUTS_KEY = PREFIX + "connection.retries.on.timeouts";
    int     CONNECTION_RETRIES_ON_SOCKET_TIMEOUTS_DEFAULT = 0;
  }
  
  /** dfs.client.write configuration properties */
  interface Write {
    String PREFIX = HdfsClientConfigKeys.PREFIX + "write.";

    String  MAX_PACKETS_IN_FLIGHT_KEY = PREFIX + "max-packets-in-flight";
    int     MAX_PACKETS_IN_FLIGHT_DEFAULT = 80;
    String  EXCLUDE_NODES_CACHE_EXPIRY_INTERVAL_KEY = PREFIX + "exclude.nodes.cache.expiry.interval.millis";
    long    EXCLUDE_NODES_CACHE_EXPIRY_INTERVAL_DEFAULT = 10*MINUTE;

    interface ByteArrayManager {
      String PREFIX = Write.PREFIX + "byte-array-manager.";

      String  ENABLED_KEY = PREFIX + "enabled";
      boolean ENABLED_DEFAULT = false;
      String  COUNT_THRESHOLD_KEY = PREFIX + "count-threshold";
      int     COUNT_THRESHOLD_DEFAULT = 128;
      String  COUNT_LIMIT_KEY = PREFIX + "count-limit";
      int     COUNT_LIMIT_DEFAULT = 2048;
      String  COUNT_RESET_TIME_PERIOD_MS_KEY = PREFIX + "count-reset-time-period-ms";
      long    COUNT_RESET_TIME_PERIOD_MS_DEFAULT = 10*SECOND;
    }
  }

  /** dfs.client.block.write configuration properties */
  interface BlockWrite {
    String PREFIX = HdfsClientConfigKeys.PREFIX + "block.write.";

    String  RETRIES_KEY = PREFIX + "retries";
    int     RETRIES_DEFAULT = 3;
    String  LOCATEFOLLOWINGBLOCK_RETRIES_KEY = PREFIX + "locateFollowingBlock.retries";
    int     LOCATEFOLLOWINGBLOCK_RETRIES_DEFAULT = 5;
    String  LOCATEFOLLOWINGBLOCK_INITIAL_DELAY_MS_KEY = PREFIX + "locateFollowingBlock.initial.delay.ms";
    int     LOCATEFOLLOWINGBLOCK_INITIAL_DELAY_MS_DEFAULT = 400;

    interface ReplaceDatanodeOnFailure {
      String PREFIX = BlockWrite.PREFIX + "replace-datanode-on-failure.";

      String  ENABLE_KEY = PREFIX + "enable";
      boolean ENABLE_DEFAULT = true;
      String  POLICY_KEY = PREFIX + "policy";
      String  POLICY_DEFAULT = "DEFAULT";
      String  BEST_EFFORT_KEY = PREFIX + "best-effort";
      boolean BEST_EFFORT_DEFAULT = false;
    }
  }

  /** dfs.client.read configuration properties */
  interface Read {
    String PREFIX = HdfsClientConfigKeys.PREFIX + "read.";
    
    String  PREFETCH_SIZE_KEY = PREFIX + "prefetch.size"; 

    interface ShortCircuit {
      String PREFIX = Read.PREFIX + "shortcircuit.";

      String  KEY = PREFIX.substring(0, PREFIX.length()-1);
      boolean DEFAULT = false;
      String  SKIP_CHECKSUM_KEY = PREFIX + "skip.checksum";
      boolean SKIP_CHECKSUM_DEFAULT = false;
      String  BUFFER_SIZE_KEY = PREFIX + "buffer.size";
      int     BUFFER_SIZE_DEFAULT = 1024 * 1024;

      String  STREAMS_CACHE_SIZE_KEY = PREFIX + "streams.cache.size";
      int     STREAMS_CACHE_SIZE_DEFAULT = 256;
      String  STREAMS_CACHE_EXPIRY_MS_KEY = PREFIX + "streams.cache.expiry.ms";
      long    STREAMS_CACHE_EXPIRY_MS_DEFAULT = 5*MINUTE;
    }
  }

  /** dfs.client.short.circuit configuration properties */
  interface ShortCircuit {
    String PREFIX = Read.PREFIX + "short.circuit.";

    String  REPLICA_STALE_THRESHOLD_MS_KEY = PREFIX + "replica.stale.threshold.ms";
    long    REPLICA_STALE_THRESHOLD_MS_DEFAULT = 30*MINUTE;
  }

  /** dfs.client.mmap configuration properties */
  interface Mmap {
    String PREFIX = HdfsClientConfigKeys.PREFIX + "mmap.";

    String  ENABLED_KEY = PREFIX + "enabled";
    boolean ENABLED_DEFAULT = true;
    String  CACHE_SIZE_KEY = PREFIX + "cache.size";
    int     CACHE_SIZE_DEFAULT = 256;
    String  CACHE_TIMEOUT_MS_KEY = PREFIX + "cache.timeout.ms";
    long    CACHE_TIMEOUT_MS_DEFAULT  = 60*MINUTE;
    String  RETRY_TIMEOUT_MS_KEY = PREFIX + "retry.timeout.ms";
    long    RETRY_TIMEOUT_MS_DEFAULT = 5*MINUTE;
  }

  /** dfs.client.hedged.read configuration properties */
  interface HedgedRead {
    String  THRESHOLD_MILLIS_KEY = PREFIX + "threshold.millis";
    long    THRESHOLD_MILLIS_DEFAULT = 500;
    String  THREADPOOL_SIZE_KEY = PREFIX + "threadpool.size";
    int     THREADPOOL_SIZE_DEFAULT = 0;
  }

  /** dfs.http.client configuration properties */
  interface HttpClient {
    String  PREFIX = "dfs.http.client.";

    // retry
    String  RETRY_POLICY_ENABLED_KEY = PREFIX + "retry.policy.enabled";
    boolean RETRY_POLICY_ENABLED_DEFAULT = false;
    String  RETRY_POLICY_SPEC_KEY = PREFIX + "retry.policy.spec";
    String  RETRY_POLICY_SPEC_DEFAULT = "10000,6,60000,10"; //t1,n1,t2,n2,...
    String  RETRY_MAX_ATTEMPTS_KEY = PREFIX + "retry.max.attempts";
    int     RETRY_MAX_ATTEMPTS_DEFAULT = 10;
    
    // failover
    String  FAILOVER_MAX_ATTEMPTS_KEY = PREFIX + "failover.max.attempts";
    int     FAILOVER_MAX_ATTEMPTS_DEFAULT =  15;
    String  FAILOVER_SLEEPTIME_BASE_KEY = PREFIX + "failover.sleep.base.millis";
    int     FAILOVER_SLEEPTIME_BASE_DEFAULT = 500;
    String  FAILOVER_SLEEPTIME_MAX_KEY = PREFIX + "failover.sleep.max.millis";
    int     FAILOVER_SLEEPTIME_MAX_DEFAULT =  15000;
  }
}
