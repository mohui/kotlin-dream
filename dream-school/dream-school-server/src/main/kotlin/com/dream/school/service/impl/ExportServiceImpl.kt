package com.dream.school.service.impl

import com.dream.school.service.ExportService
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.stereotype.Service
import java.io.File
import java.io.FileOutputStream

@Service
class ExportServiceImpl: ExportService {
    override fun exceptTest() {
        val workbook: Workbook = XSSFWorkbook()

        // 创建工作表对象
        val sheet = workbook.createSheet("Sheet1")

        // 创建行对象
        val row = sheet.createRow(0)

        // 创建单元格对象并设置值
        val cell = row.createCell(0)
        cell.setCellValue("Hello, World!")

        // 指定导出的相对路径
        val relativePath = "output.xlsx"
        // 获取项目根目录的绝对路径
        val projectDir = System.getProperty("user.dir")
        // 构建导出文件的绝对路径
        val filePath = File(projectDir, relativePath).absolutePath
        println(filePath)

        // 导出 Excel 文件
        val fileOut = FileOutputStream(File(relativePath))
        workbook.write(fileOut)
        fileOut.close()

        // 打印完成信息
        println("Excel 导出完成！")
    }
}