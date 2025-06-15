package com.example.TubesOOP.enums;

public enum BookingStatus {
    MENUNGGU, //baru dibuat, belum diproses
    DIPROSES, //sudah di-assign ke collector
    SELESAI, //selesai
    DIBATALKAN //dibatalkan dari admin atau user
}
