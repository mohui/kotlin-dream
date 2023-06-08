package com.dream.school.service.impl

import com.dream.school.constant.AREA_LIST
import com.dream.school.service.ExportService
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.stereotype.Service
import java.io.DataOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.net.HttpURLConnection
import java.net.URL

@Service
class ExportServiceImpl: ExportService {
    /**
     * 导出excel
     */
    override fun exceptTest() {
        val workbook: Workbook = XSSFWorkbook()

        // 创建工作表对象
        val sheet = workbook.createSheet("地区列表")

        // 创建行对象
        val headerRow = sheet.createRow(0)

        // 创建单元格对象并设置值(创建表头)
        headerRow.createCell(0).setCellValue("地区ID")
        headerRow.createCell(1).setCellValue("地区名称")
        headerRow.createCell(2).setCellValue("上级地区ID")

        // 填充数据行
        var rowIndex = 1
        for (area in AREA_LIST) {
            val dataRow = sheet.createRow(rowIndex++)
            dataRow.createCell(0).setCellValue(area.code)
            dataRow.createCell(1).setCellValue(area.name)
            dataRow.createCell(2).setCellValue(area.parent)
        }

        // 指定导出的相对路径
        val relativePath = "地区列表.xlsx"
        // 获取项目根目录的绝对路径(用不到)
        val projectDir = System.getProperty("user.dir")
        // 构建导出文件的绝对路径(用不到)
        val filePath = File(projectDir, relativePath).absolutePath

        // 导出 Excel 文件
        val fileOut = FileOutputStream(File(relativePath))
        workbook.write(fileOut)
        fileOut.close()

        // 打印完成信息
        println("Excel 导出完成！")
    }

    override fun upload() {
        TODO("Not yet implemented")
    }
}