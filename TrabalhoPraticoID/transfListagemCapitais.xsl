<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output method="text" encoding="UTF-8"/>

<xsl:template match="/">
  <xsl:text>Listagem de Paises e Capitais:</xsl:text>
 <xsl:text>&#10;</xsl:text>  
 <xsl:text>&#10;</xsl:text> 

  <xsl:for-each select="factos/pais">
    <xsl:value-of select="nome"/>
    <xsl:text> - </xsl:text> 
    <xsl:value-of select="capital"/>
    <xsl:text>&#10;</xsl:text> 
  </xsl:for-each>
</xsl:template>

</xsl:stylesheet>
