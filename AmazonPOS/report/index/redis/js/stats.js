var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "200",
        "ok": "200",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "1452",
        "ok": "1452",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "4261",
        "ok": "4261",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "2950",
        "ok": "2950",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "1258",
        "ok": "1258",
        "ko": "-"
    },
    "percentiles1": {
        "total": "3329",
        "ok": "3329",
        "ko": "-"
    },
    "percentiles2": {
        "total": "4181",
        "ok": "4181",
        "ko": "-"
    },
    "percentiles3": {
        "total": "4231",
        "ok": "4231",
        "ko": "-"
    },
    "percentiles4": {
        "total": "4252",
        "ok": "4252",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 200,
    "percentage": 100
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "16.667",
        "ok": "16.667",
        "ko": "-"
    }
},
contents: {
"req_request-1-46da4": {
        type: "REQUEST",
        name: "request_1",
path: "request_1",
pathFormatted: "req_request-1-46da4",
stats: {
    "name": "request_1",
    "numberOfRequests": {
        "total": "100",
        "ok": "100",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "1452",
        "ok": "1452",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "2560",
        "ok": "2560",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "1715",
        "ok": "1715",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "343",
        "ok": "343",
        "ko": "-"
    },
    "percentiles1": {
        "total": "1569",
        "ok": "1569",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1621",
        "ok": "1621",
        "ko": "-"
    },
    "percentiles3": {
        "total": "2485",
        "ok": "2485",
        "ko": "-"
    },
    "percentiles4": {
        "total": "2560",
        "ok": "2560",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 100,
    "percentage": 100
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "8.333",
        "ok": "8.333",
        "ko": "-"
    }
}
    },"req_request-2-93baf": {
        type: "REQUEST",
        name: "request_2",
path: "request_2",
pathFormatted: "req_request-2-93baf",
stats: {
    "name": "request_2",
    "numberOfRequests": {
        "total": "100",
        "ok": "100",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "4097",
        "ok": "4097",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "4261",
        "ok": "4261",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "4184",
        "ok": "4184",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "34",
        "ok": "34",
        "ko": "-"
    },
    "percentiles1": {
        "total": "4182",
        "ok": "4182",
        "ko": "-"
    },
    "percentiles2": {
        "total": "4202",
        "ok": "4202",
        "ko": "-"
    },
    "percentiles3": {
        "total": "4248",
        "ok": "4248",
        "ko": "-"
    },
    "percentiles4": {
        "total": "4256",
        "ok": "4256",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 100,
    "percentage": 100
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "8.333",
        "ok": "8.333",
        "ko": "-"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
