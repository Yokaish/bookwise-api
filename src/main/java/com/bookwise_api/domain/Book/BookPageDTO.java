package com.bookwise_api.domain.Book;

import java.util.List;

public record BookPageDTO(
        List<BookResponseDTO> content,
        int pageNumber,
        int pageSize,
        long totalElements,
        int totalPages,
        boolean first,
        boolean last
) {

}
