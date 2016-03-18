<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:xdt="http://www.w3.org/2005/xpath-datatypes" xmlns:date="http://exslt.org/dates-and-times">
    <xsl:variable name="fo:layout-master-set">
        <fo:layout-master-set>
            <fo:simple-page-master master-name="cover-page-master" page-height="11.69in" page-width="8.27in">
                <fo:region-body />
            </fo:simple-page-master>
            <fo:simple-page-master master-name="default-page" page-height="11.69in" page-width="8.27in" margin-left="0.6in" margin-right="0.6in">
                <fo:region-before extent="0.79in" />
                <fo:region-body margin-top="0.79in" margin-bottom="0.79in" />
                <fo:region-after extent="0.79in" />
            </fo:simple-page-master>
        </fo:layout-master-set>
    </xsl:variable>
    <xsl:output version="1.0" encoding="UTF-8" indent="no" omit-xml-declaration="no" media-type="text/html" />

<xsl:variable name="now" select="date:date-time()"/>
<xsl:variable name="hours" select="format-number(date:hour-in-day(),'00')"/>
<xsl:variable name="minutes" select="format-number(date:minute-in-hour(),'00')"/>

    <xsl:template match="/">
        <fo:root>
            <xsl:copy-of select="$fo:layout-master-set" />
            <fo:page-sequence master-reference="cover-page-master">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block>
                        <fo:table start-indent="(8.27in - ((8.27in * 80) div 100) ) div 2" end-indent="(8.27in - ((8.27in * 80) div 100) ) div 2" text-align="center" width="80%" space-before.optimum="1pt" space-after.optimum="2pt">
                            <fo:table-column column-width="1pt" />
                            <fo:table-column />
                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell border-style="solid" border-width="1pt" border-color="white" height="75pt" number-rows-spanned="2" width="1pt" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start">
                                        <fo:block />
                                    </fo:table-cell>
                                    <fo:table-cell border-style="solid" border-width="1pt" border-color="white" height="75pt" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start">
                                        <fo:block />
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell border-style="solid" border-width="1pt" border-color="white" height="615pt" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start">
                                        <fo:block>
                                            <fo:block border-style="solid" border-width="1pt" border-color="#808080" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" space-before.optimum="1pt" space-after.optimum="2pt">
                                                <fo:block background-image="http://localhost:8080/Cave2/images/fond.gif" color="#FCFEF2">
                                                    <fo:block text-align="center" space-before.optimum="1pt" space-after.optimum="2pt">
                                                        <fo:block>
                                                            <fo:block font-size="24pt" font-weight="bold" space-before.optimum="1pt" space-after.optimum="2pt">
                                                                <fo:block>
                                                                    <fo:block>
                                                                        <fo:leader leader-pattern="space" />
                                                                    </fo:block>
                                                                    <fo:block>
                                                                        <fo:leader leader-pattern="space" />
                                                                    </fo:block>
                                                                    <fo:block>
                                                                        <fo:leader leader-pattern="space" />
                                                                    </fo:block>
                                                                    <fo:block>
                                                                        <fo:leader leader-pattern="space" />
                                                                    </fo:block>
                                                                    <fo:block>
                                                                        <fo:leader leader-pattern="space" />
                                                                    </fo:block>
                                                                    <fo:block>
                                                                        <fo:leader leader-pattern="space" />
                                                                    </fo:block>
                                                                    <fo:block>
                                                                        <fo:leader leader-pattern="space" />
                                                                    </fo:block>
                                                                    <fo:block>
                                                                        <fo:leader leader-pattern="space" />
                                                                    </fo:block>
                                                                    <fo:block>
                                                                        <fo:leader leader-pattern="space" />
                                                                    </fo:block>
                                                                    <fo:inline color="#B0A57D">Etat de la cave</fo:inline>
                                                                    <fo:block>
                                                                        <fo:leader leader-pattern="space" />
                                                                    </fo:block>
                                                                    <fo:block>
                                                                        <fo:leader leader-pattern="space" />
                                                                    </fo:block>
                                                                    <fo:inline color="#B0A57D" font-size="12pt">au <xsl:value-of select="concat(date:day-in-month($now), ' ',
                                 date:month-name($now), ' ',
                                 date:year($now))"/>
    à <xsl:value-of select="concat($hours,':',$minutes)"/>
</fo:inline>
    
                                                                </fo:block>
                                                            </fo:block>
                                                            <fo:block font-size="18pt" font-weight="bold" space-before.optimum="1pt" space-after.optimum="2pt">
                                                                <fo:block>
                                                                    <fo:block>
                                                                        <fo:leader leader-pattern="space" />
                                                                    </fo:block>
                                                                    <fo:block>
                                                                        <fo:leader leader-pattern="space" />
                                                                    </fo:block>
                                                                    <fo:block>
                                                                        <fo:leader leader-pattern="space" />
                                                                    </fo:block>
                                                                    <fo:block>
                                                                        <fo:leader leader-pattern="space" />
                                                                    </fo:block>
                                                                    <fo:block>
                                                                        <fo:leader leader-pattern="space" />
                                                                    </fo:block>
                                                                    <fo:block>
                                                                        <fo:leader leader-pattern="space" />
                                                                    </fo:block>
                                                                    <fo:block>
                                                                        <fo:leader leader-pattern="space" />
                                                                    </fo:block>
                                                                    <fo:block>
                                                                        <fo:leader leader-pattern="space" />
                                                                    </fo:block>
                                                                    <fo:block>
                                                                        <fo:leader leader-pattern="space" />
                                                                    </fo:block>
                                                                    <fo:block>
                                                                        <fo:leader leader-pattern="space" />
                                                                    </fo:block>
                                                                    <fo:block>
                                                                        <fo:leader leader-pattern="space" />
                                                                    </fo:block>
                                                                    <fo:block>
                                                                        <fo:leader leader-pattern="space" />
                                                                    </fo:block>
                                                                    <fo:block>
                                                                        <fo:leader leader-pattern="space" />
                                                                    </fo:block>
                                                                    <fo:block>
                                                                        <fo:leader leader-pattern="space" />
                                                                    </fo:block>
                                                                    <fo:block>
                                                                        <fo:leader leader-pattern="space" />
                                                                    </fo:block>
                                                                    <fo:block>
                                                                        <xsl:text>&#xA;</xsl:text>
                                                                    </fo:block>
                                                                </fo:block>
                                                            </fo:block>
                                                        </fo:block>
                                                    </fo:block>
                                                </fo:block>
                                            </fo:block>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
            <fo:page-sequence master-reference="default-page" initial-page-number="1" format="1">
                <fo:static-content flow-name="xsl-region-before">
                    <fo:block>
                        <fo:block>
                            <fo:leader leader-pattern="space" />
                        </fo:block>
                        <fo:block>
                            <xsl:text>&#xA;</xsl:text>
                        </fo:block>
                        <fo:table background-color="#F8FFE3" text-align="justify" width="80%" space-before.optimum="1pt" space-after.optimum="2pt">
                            <fo:table-column column-width="proportional-column-width(10)" />
                            <fo:table-column column-width="proportional-column-width(80)" />
                            <fo:table-column column-width="proportional-column-width(10)" />
                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell background-image="http://localhost:8080/Cave2/images/gauche.gif" border-style="solid" border-width="1pt" border-color="#F8FFE3" height="10pt" number-rows-spanned="2" text-align="center" width="10%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center">
                                        <fo:block />
                                    </fo:table-cell>
                                    <fo:table-cell border-style="solid" border-width="1pt" border-color="#F8FFE3" height="10pt" text-align="right" width="80%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center">
                                        <fo:block>
                                            <fo:inline color="#B0A57D" font-style="italic">VieilleCave.com
</fo:inline>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell background-image="http://localhost:8080/Cave2/images/droite.gif" border-style="solid" border-width="1pt" border-color="#F8FFE3" height="10pt" number-rows-spanned="2" text-align="center" width="10%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center">
                                        <fo:block />
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell background-image="http://localhost:8080/Cave2/images/trait.gif" border-style="solid" border-width="1pt" border-color="#F8FFE3" height="1pt" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start">
                                        <fo:block />
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>
                </fo:static-content>
                <fo:static-content flow-name="xsl-region-after" display-align="after">
                    <fo:block>
                        <fo:block>
                            <fo:leader leader-pattern="space" />
                        </fo:block>
                        <fo:block>
                            <xsl:text>&#xA;</xsl:text>
                        </fo:block>
                        <fo:block space-before.optimum="1pt" space-after.optimum="2pt">
                            <fo:block text-align="right">
                                <fo:block>
                                    <fo:leader leader-pattern="space" />
                                </fo:block>Page <fo:page-number />
                            </fo:block>
                        </fo:block>
                    </fo:block>
                </fo:static-content>
                <fo:flow flow-name="xsl-region-body">
                    <fo:block>
                        <xsl:for-each select="CAVE">
                            <fo:table background-color="#DDD9C6" width="100%" space-before.optimum="1pt" space-after.optimum="2pt">
                                <fo:table-column column-width="533pt" />
                                <fo:table-body>
                                    <fo:table-row>
                                        <fo:table-cell border-style="solid" border-width="1pt" border-color="#DDD9C6" text-align="center" width="533pt" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center">
                                            <fo:block>
                                                <fo:table width="100%" space-before.optimum="1pt" space-after.optimum="2pt">
                                                    <fo:table-column column-width="110pt" />
                                                    <fo:table-column column-width="410pt" />
                                                    <fo:table-body>
                                                        <xsl:for-each select="APPELLATION">
                                                            <fo:table-row>
                                                                <fo:table-cell border-style="solid" border-width="1pt" border-color="black" display-align="before" height="1pt" width="110pt" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" text-align="start">
                                                                    <fo:block>
                                                                        <xsl:for-each select="NOM_APPELLATION">
                                                                            <fo:inline font-weight="bold">
                                                                                <xsl:apply-templates />
                                                                            </fo:inline>
                                                                        </xsl:for-each>
                                                                    </fo:block>
                                                                </fo:table-cell>
                                                                <fo:table-cell border-style="solid" border-width="1pt" border-color="black" background-color="#F8FFE3" display-align="before" height="1pt" width="410pt" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" text-align="start">
                                                                    <fo:block>
                                                                        <xsl:for-each select="CHATEAU">
                                                                            <fo:table background-color="#F8FFE3" width="100%" space-before.optimum="1pt" space-after.optimum="2pt">
                                                                                <fo:table-column column-width="154pt" />
                                                                                <fo:table-column />
                                                                                <fo:table-body>
                                                                                    <fo:table-row>
                                                                                        <fo:table-cell border-style="solid" border-width="1pt" border-color="#F8FFE3" display-align="before" height="27pt" width="154pt" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" text-align="start">
                                                                                            <fo:block>
                                                                                                <xsl:for-each select="NOM_CHATEAU">
                                                                                                    <xsl:apply-templates />
                                                                                                </xsl:for-each>
                                                                                            </fo:block>
                                                                                        </fo:table-cell>
                                                                                        <fo:table-cell border-style="solid" border-width="1pt" border-color="#F8FFE3" height="27pt" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start">
                                                                                            <fo:block>
                                                                                                <xsl:for-each select="BOUTEILLE">
                                                                                                    <fo:table padding="2" width="100%" space-before.optimum="1pt" space-after.optimum="2pt">
                                                                                                        <fo:table-column column-width="74pt" />
                                                                                                        <fo:table-column />
                                                                                                        <fo:table-body>
                                                                                                            <fo:table-row>
                                                                                                                <fo:table-cell border-style="solid" border-width="1pt" border-color="black" padding-start="2pt" padding-end="2pt" padding-before="2pt" padding-after="2pt" display-align="center" height="12pt" text-align="center" width="74pt">
                                                                                                                    <fo:block>
                                                                                                                        <xsl:for-each select="NOM">
                                                                                                                            <xsl:apply-templates />
                                                                                                                        </xsl:for-each>
                                                                                                                    </fo:block>
                                                                                                                </fo:table-cell>
                                                                                                                <fo:table-cell border-style="solid" border-width="1pt" border-color="black" padding-start="2pt" padding-end="2pt" padding-before="2pt" padding-after="2pt" display-align="before" height="12pt" text-align="start">
                                                                                                                    <fo:block>
                                                                                                                        <xsl:for-each select="CUVEE">
                                                                                                                            <fo:table background-color="#F8FFE3" padding="0" width="100%" space-before.optimum="1pt" space-after.optimum="2pt">
                                                                                                                                <fo:table-column />
                                                                                                                                <fo:table-column />
                                                                                                                                <fo:table-body>
                                                                                                                                    <fo:table-row>
                                                                                                                                        <fo:table-cell border-style="solid" border-width="1pt" border-color="#F8FFE3" padding-start="0pt" padding-end="0pt" padding-before="0pt" padding-after="0pt" display-align="before" height="1pt" number-columns-spanned="2" text-align="start">
                                                                                                                                            <fo:block>
                                                                                                                                                <xsl:for-each select="@annee">cuvée <xsl:value-of select="." />
                                                                                                                                                </xsl:for-each>
                                                                                                                                                <xsl:for-each select="NOMBRE">, <xsl:apply-templates /> bouteilles</xsl:for-each>
                                                                                                                                            </fo:block>
                                                                                                                                        </fo:table-cell>
                                                                                                                                    </fo:table-row>
                                                                                                                                </fo:table-body>
                                                                                                                            </fo:table>
                                                                                                                        </xsl:for-each>
                                                                                                                    </fo:block>
                                                                                                                </fo:table-cell>
                                                                                                            </fo:table-row>
                                                                                                        </fo:table-body>
                                                                                                    </fo:table>
                                                                                                </xsl:for-each>
                                                                                            </fo:block>
                                                                                        </fo:table-cell>
                                                                                    </fo:table-row>
                                                                                </fo:table-body>
                                                                            </fo:table>
                                                                        </xsl:for-each>
                                                                    </fo:block>
                                                                </fo:table-cell>
                                                            </fo:table-row>
                                                        </xsl:for-each>
                                                    </fo:table-body>
                                                </fo:table>
                                            </fo:block>
                                        </fo:table-cell>
                                    </fo:table-row>
                                </fo:table-body>
                            </fo:table>
                        </xsl:for-each>
                        <fo:block>
                            <xsl:text>&#xA;</xsl:text>
                        </fo:block>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
    <xsl:template match="APPELLATION">
        <fo:table width="100%" space-before.optimum="1pt" space-after.optimum="2pt">
            <fo:table-column />
            <fo:table-column column-width="456pt" />
            <fo:table-column />
            <fo:table-column />
            <fo:table-column />
            <fo:table-body>
                <fo:table-row>
                    <fo:table-cell border-style="solid" border-width="1pt" border-color="black" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start">
                        <fo:block>
                            <xsl:for-each select="NOM_APPELLATION">
                                <xsl:apply-templates />
                            </xsl:for-each>
                        </fo:block>
                    </fo:table-cell>
                    <fo:table-cell border-style="solid" border-width="1pt" border-color="black" width="456pt" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start">
                        <fo:block>
                            <xsl:for-each select="CHATEAU">
                                <xsl:for-each select="NOM_CHATEAU">
                                    <xsl:apply-templates />
                                </xsl:for-each>
                            </xsl:for-each>
                        </fo:block>
                    </fo:table-cell>
                    <fo:table-cell border-style="solid" border-width="1pt" border-color="black" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start">
                        <fo:block>
                            <xsl:for-each select="CHATEAU">
                                <xsl:for-each select="BOUTEILLE">
                                    <xsl:for-each select="NOM">
                                        <xsl:apply-templates />
                                    </xsl:for-each>
                                </xsl:for-each>
                            </xsl:for-each>
                        </fo:block>
                    </fo:table-cell>
                    <fo:table-cell border-style="solid" border-width="1pt" border-color="black" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start">
                        <fo:block>
                            <xsl:for-each select="CHATEAU">
                                <xsl:for-each select="BOUTEILLE">
                                    <xsl:for-each select="CUVEE">
                                        <xsl:for-each select="@annee">
                                            <xsl:value-of select="." />
                                        </xsl:for-each>
                                    </xsl:for-each>
                                </xsl:for-each>
                            </xsl:for-each>
                        </fo:block>
                    </fo:table-cell>
                    <fo:table-cell border-style="solid" border-width="1pt" border-color="black" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start">
                        <fo:block>
                            <xsl:for-each select="CHATEAU">
                                <xsl:for-each select="BOUTEILLE">
                                    <xsl:for-each select="CUVEE">
                                        <xsl:for-each select="NOMBRE">
                                            <xsl:apply-templates />
                                        </xsl:for-each>
                                    </xsl:for-each>
                                </xsl:for-each>
                            </xsl:for-each>
                        </fo:block>
                    </fo:table-cell>
                </fo:table-row>
            </fo:table-body>
        </fo:table>
    </xsl:template>
    <xsl:template match="CHATEAU">
        <xsl:apply-templates />
    </xsl:template>
</xsl:stylesheet>
