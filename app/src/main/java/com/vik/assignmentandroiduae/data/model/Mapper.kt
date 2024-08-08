package com.vik.assignmentandroiduae.data.model

import com.vik.assignmentandroiduae.domain.model.University

fun UniversityDto.toEntity(): UniversityEntity{
    return UniversityEntity(
        alphaTwoCode = this.alpha_two_code,
        name = this.name,
        country = this.country,
        domains = this.domains,
        state =  this.state,
        web_pages = this.webPages
    )
}

fun UniversityEntity.toDto(): UniversityDto? {
    return UniversityDto(
        id = this.id,
        alpha_two_code = this.alphaTwoCode,
        name = this.name,
        country = this.country,
        domains = this.domains,
        state = this.state,
        webPages = this.web_pages
    )
}


fun UniversityEntity.toUniversityModel(): University? {
    return University(
        alpha_two_code = this.alphaTwoCode,
        name = this.name,
        country = this.country,
        domains = this.domains,
        state = this.state,
        web_pages = this.web_pages
    )
}


fun mapFromDto(dto: UniversityDto): University? {
    return University(
        alpha_two_code = dto.alpha_two_code,
        name = dto.name,
        country = dto.country,
        domains = dto.domains,
        state = dto.state,
        web_pages = dto.webPages
    )
}
