package com.example.quanlycongviecmoi

class CongViec(
    var tenCongViec: String,
    var moTa: String,
    var trangThai: Boolean
) {
    fun layThongTin(): String {
        val trangThaiStr = if (trangThai) "Đã hoàn thành" else "Chưa hoàn thành"
        return "Tên: $tenCongViec\nMô tả: $moTa\nTrạng thái: $trangThaiStr"
    }
}